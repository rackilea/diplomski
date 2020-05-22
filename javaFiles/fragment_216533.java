String in = "the company generated sales of EUR 1.000.000,5 in 2016";
Pattern p = Pattern.compile(
    "((?i:EUR)\\s?(?:(?=(\\d*,){2})\\d{1,3}(,\\d{3})*(\\.\\d+)?|(?=(\\d*\\.){2})\\d{1,3}(\\.\\d{3})*(,\\d+)?|\\d+(?:[.,]\\d+)?)\\s?(?i:Mio|Million|Billion)?)" );
Matcher m = p.matcher( in );
while ( m.find() ) {
    System.out.println( m.group( 1 ) );
}