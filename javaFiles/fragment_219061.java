@Singleton
@Startup

public class BackgroundJobManager {

@Schedule(hour="0", minute="0", second="0", persistent=false)
public void someDailyJob() {
    // Do your job here which should run every start of day.
    System.out.println("");
}

@Schedule(hour="*/1", minute="0", second="0", persistent=false)
public void someHourlyJob() {
    // Do your job here which should run every hour of day.
}

@Schedule(hour="*", minute="*/15", second="0", persistent=false)
public void someQuarterlyJob() {
    // Do your job here which should run every 15 minute of hour.
    System.out.println("Imprimir cada 15 mins");
}

@Schedule(hour="*", minute="*/1", second="0", persistent=false)
public void someMinuteJob() {
    // Do your job here which should run every minute of the hour.
    System.out.println("Imprimir cada 1 mins");
}