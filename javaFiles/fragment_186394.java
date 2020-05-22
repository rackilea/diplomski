import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;

public Duration fromTheFormat( String str ) {
    Period period = new Period( /* years = */ 0,
                                /* months = */ 0,
                                /* weeks = */ 0,
                                /* days = */ parseInt( str.substring( 0, 1 ) ),
                                /* hours = */ parseInt( str.substring( 1, 3 ) ),
                                /* minutes = */ parseInt( str.substring( 3, 5 ),
                                /* seconds = */ 0,
                                /* millis = */ 0
    );

    // or best one is
    PeriodFormatter pf = new PeriodFormatterBuilder()
                           .minimumPrintedDigits( 1 )
                           .maximumParsedDigits( 1 )
                           .appendDays()
                           .minimumPrintedDigits( 2 )
                           .maximumParsedDigits( 2 )
                           .appendHours()
                           .appendMinutes()
                           .toFormatter();

    period = pf.parsePeriod( str );

    return period.toStandardDuration();
}