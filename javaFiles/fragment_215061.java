package work.basil.example;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DailyCountdown implements Runnable {
    private LocalDate dueDate;
    private Long daysRemaining;

    public DailyCountdown ( LocalDate dueDate ) {
        this.dueDate = dueDate;
    }

    @Override
    public void run () {
        try {
            System.out.println( "DEBUG - Running the DailyCountdown::run method at " + Instant.now() );
            ZoneId z = ZoneId.of( "America/Montreal" );  // Or ZoneId.systemDefault() to rely on the JVM’s current default time zone.
            LocalDate today = LocalDate.now( z );
            Long count = ChronoUnit.DAYS.between( today , this.dueDate );
            if ( Objects.isNull( this.daysRemaining ) ) {
                this.daysRemaining = ( count - 1 );
            }
            if ( this.daysRemaining.equals( count ) ) {
                // Do nothing.
            } else {
                // … Schedule on another thread for the GUI to update with the new number.
                this.daysRemaining = count;
            }
        } catch ( Exception e ) {
            // Log this unexpected exception, and notify sysadmin.
            // Any uncaught exception reaching the scheduled executor service would have caused it to silently halt any further scheduling.
        }
    }

    public static void main ( String[] args ) {
        // Put this code where ever appropriate, when setting up your GUI after the app launches.
        Runnable r = new DailyCountdown( LocalDate.of( 2018 , Month.FEBRUARY , 15 ) );
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleWithFixedDelay( r , 0L , 1L , TimeUnit.MINUTES );

        // Be sure to gracefully shutdown the ScheduledExecutorService when your program is stopping. Otherwise, the executor may continue running indefinitely on the background thread.
        try {
            Thread.sleep( TimeUnit.MINUTES.toMillis( 7 ) ); // Sleep 7 minutes to let the background thread do its thing.
        } catch ( InterruptedException e ) {
            System.out.println( "The `main` thread was woken early from sleep." );
        }
        ses.shutdown();
        System.out.println( "App is exiting at " + Instant.now() ) ;
    }
}