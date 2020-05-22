public static void main( final String[] args ) throws ParseException {
    final String sdate = "2012-01-01";
    final SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd" );
    final Date date = df.parse( sdate ); // conversion from String
    final java.util.Calendar cal = GregorianCalendar.getInstance();
    cal.setTime( date );
    cal.add( GregorianCalendar.MONTH, 5 ); // date manipulation
    System.out.println( "result: " + df.format( cal.getTime() ) ); // conversion to String
}