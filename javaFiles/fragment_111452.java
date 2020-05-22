long data1 = 25682400000L;
long data2 = 25686000000L;

DateTimeZone timeZone = DateTimeZone.forID( "America/Chicago" );

DateTime dateTime1 = new DateTime( data1, timeZone );
DateTime dateTime1_UTC_GMT = dateTime1.toDateTime( DateTimeZone.UTC );

DateTime dateTime2 = new DateTime( data2, timeZone );
DateTime dateTime2_UTC_GMT = dateTime2.toDateTime( DateTimeZone.UTC );