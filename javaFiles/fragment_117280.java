SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
try {
  Date myDate = sdf.parse( "2011-12-06T07:41:14.016+00:00".replaceAll( "([0-9\\-T]+:[0-9]{2}:[0-9.+]+):([0-9]{2})", "$1$2" ) );
  System.out.println( myDate );
} catch (ParseException e) {
  e.printStackTrace();
}