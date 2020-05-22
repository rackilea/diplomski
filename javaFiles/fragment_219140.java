Locale l = new Locale ( "hi" , "IN" );

// java.time
DateTimeFormatter f = DateTimeFormatter.ofPattern ( "MMMM dd uuuu" ).withLocale ( l );
System.out.println ( ZonedDateTime.now ().format ( f ) );

// Legacy date-time classes.
SimpleDateFormat dFormat = new SimpleDateFormat ( "MMMM dd yyyy" , l );
System.out.println ( dFormat.format ( new java.util.Date () ) );