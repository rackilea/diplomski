package work.basil.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CalendarMaker
{
    // Member variables.
    private String eol;
    private Locale locale;
    static private DateTimeFormatter DAY_FORMATTER = DateTimeFormatter.ofPattern( "ppd" ); // Use `dd` to pad single-digits values with a leading zero. Use `ppd` to pad with a SPACE.

    // Constructor

    public CalendarMaker ( String eol , Locale locale )
    {
        this.eol = eol;
        this.locale = locale;
    }

    private CharSequence generateYear ( final Year year )
    {
        // Year header.
        StringBuilder sb = new StringBuilder();
        sb.append( "|------  " + year + "  ------|" ).append( this.eol ).append( this.eol );

        // Each month.
        for ( Month month : EnumSet.allOf( Month.class ) )
        {
            YearMonth ym = YearMonth.of( year.getValue() , month );
            CharSequence monthCalendar = this.generateMonth( ym );
            sb.append( monthCalendar );
        }
        return sb;
    }

    private CharSequence generateMonth ( final YearMonth yearMonth )
    {
        // Title
        StringBuilder sb = new StringBuilder();
        String monthName = yearMonth.getMonth().getDisplayName( TextStyle.FULL , this.locale );
        sb.append( yearMonth.getYear() ).append( " " ).append( monthName ).append( this.eol );

        // Column headers.
        DayOfWeek firstDayOfWeek = WeekFields.of( this.locale ).getFirstDayOfWeek();
        List < DayOfWeek > dows =
                IntStream
                        .range( 0 , 7 )
                        .mapToObj( firstDayOfWeek :: plus )
                        .collect( Collectors.toList() );
        String columnHeaders =
                dows
                        .stream()
                        .map( dayOfWeek -> dayOfWeek.getDisplayName( TextStyle.SHORT_STANDALONE , this.locale ).substring( 0 , 2 ) )
                        .collect( Collectors.joining( " " ) );
        sb.append( columnHeaders ).append( this.eol );

        // Rows (each week)
        LocalDate localDate = yearMonth.atDay( 1 ).with( TemporalAdjusters.previousOrSame( firstDayOfWeek ) ); // Get the first date of the month, then move backwards in time to determine the first date that fits our calendar grid. May be the same as the first, or may be earlier date from the previous month.
        while ( ! localDate.isAfter( yearMonth.atEndOfMonth() ) )  // "Not after" is a shorter way of saying "is equal to or sooner than".
        {
            String week =
                    localDate
                            .datesUntil( localDate.plusWeeks( 1 ) )  // Get a stream of dates via `LocalDate::datesUntil`. The ending date is exclusive (half-open).
                            .map( ld -> ( YearMonth.from( ld ).equals( yearMonth ) ? ld.format( CalendarMaker.DAY_FORMATTER ) : "  " ) ) // Display the day-of-month number if within the target month, otherwise display a pair of SPACE characters.
                            .collect( Collectors.joining( " " ) );  // Separate columns with a SPACE in our calendar grid.
            sb.append( week ).append( this.eol ); // Add this row of text for the week, and wrap to next line for next loop.
            localDate = localDate.plusWeeks( 1 );  // Increment one week at a time to set up our next loop.
        }

        // Footer (for the month)
        sb.append( this.eol );  // Put a blank line after every month.
        return sb;
    }

    // Demonstrate this class with a psvm method.
    public static void main ( String[] args )
    {

        CalendarMaker calendarMaker = new CalendarMaker( "\n" , Locale.CANADA_FRENCH );

        // Demonstrate 3 years: previous year, current, and next year.
        Year currentYear = Year.now( ZoneId.of( "America/Boise" ) );
        List < Year > years = List.of( currentYear.minusYears( 1 ) , currentYear , currentYear.plusYears( 1 ) );
        for ( Year year : years )
        {
            CharSequence calendar = calendarMaker.generateYear( year );
            System.out.println( "" );
            System.out.println( calendar );
        }
    }

}