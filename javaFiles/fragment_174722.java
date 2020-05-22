public static Date convertLocalDateToDateTimezone( Date localDate, String timezone ) {
   TimeZone localTimeZone = TimeZone.getDefault();
   TimeZone timezone = TimeZone.getTimeZone( timezone );
   long gmtMillis = localDate.getTime();
   long result = gmtMillis + timezone.getOffset( gmtMillis ) - localTimeZone.getOffset(     gmtMillis );
   return new Date( result );
}