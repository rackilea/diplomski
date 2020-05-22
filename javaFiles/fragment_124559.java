// Specify the time zone rather than rely on default. https://en.wikipedia.org/wiki/List_of_tz_database_time_zones
DateTimeZone timeZone = DateTimeZone.forID( "Europe/Rome" );
DateTime a = new DateTime( 2014, 1, 2, 8, 6, 0, timeZone );
DateTime b = new DateTime( 2014, 1, 2, 8, 0, 0, timeZone );
Period period = new Period( a, b);
long millis = period.toStandardDuration().getMillis();