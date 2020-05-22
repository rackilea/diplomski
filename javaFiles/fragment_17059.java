LocalTime now = LocalTime.now();
LocalTime start = new LocalTime( 13, 0, 0, 0 );
LocalTime stop = start.plusHours( 11 );

System.out.println( "now: " + now );
System.out.println( "start: " + start );
System.out.println( "stop: " + stop );

if ( now.isAfter( start ) ) {
    System.out.println( "After start" );
}

if ( now.isBefore( stop ) ) {
    System.out.println( "Before stop" );
}