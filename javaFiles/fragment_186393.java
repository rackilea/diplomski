import org.joda.time.Duration;

public Duration fromTheFormat( String str ) {
    Duration dayDuration = Duration.standardDays( parseInt( str.substring( 0, 1 ) ) );
    Duration hourDuration = Duration.standardHours( parseInt( str.substring( 1, 3 ) ) );
    Duration minuteDuration = Duration.standardMinutes( parseInt( str.substring( 3, 5 ) ) );

    return dayDuration.plus( hourDuration.getMillis() ).plus( minuteDuration.millis() );
}