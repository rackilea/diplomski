// Calendar - Timezone UTC
cal = new GregorianCalendar( TimeZone.getTimeZone( "UTC" ) );
cal.setTimeInMillis( timeInSecs * 1000 );
simpleDateFormat.setTimeZone( TimeZone.getTimeZone( "UTC" ) ); // <-- like so.
result = simpleDateFormat.format( cal.getTime() );
cal.set( 1970, Calendar.JANUARY, 1, 0, 0, timeInSecs );
result = simpleDateFormat.format( cal.getTime() );