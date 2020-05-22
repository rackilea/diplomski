private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.FULL ).withLocale( Locale.CANADA_FRENCH ) ;
private static final ZoneId ZONE_ID = ZoneId.of( "America/Montreal" );

public static final String eventTypeToDateTimeString(long timestamp)
{
   return Instant.ofEpochMilli( timestamp ).atZone( ZONE_ID ).format( DATE_TIME_FORMATTER );
}