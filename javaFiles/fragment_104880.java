public static double convert(String number) {

  //this should be defined outside and is here just for simplicity reasons
  Map<String, Double> mapping = new HashMap<String, Double>();
  mapping.put( "k", 1000.0 );
  mapping.put( "m", 0.001 );

  //Use a specified Locale or otherwise the results would depend on your system locale
  NumberFormat f = NumberFormat.getNumberInstance( Locale.ENGLISH );
  ParsePosition p = new ParsePosition( 0 );

  Number n = f.parse( number, p  );
  String suffix = number.substring( p.getIndex() );
  Double factor = mapping.get( suffix );

  return n.doubleValue() * factor;