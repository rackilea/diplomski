public static void main( String[] args ) {
  String pattern = "[A-Za-z0-9!@#$%^&*()-_=+;:',./?\\ ]*";
  String text = "Hello, I need everything in this string except the { or }";

  Pattern p = Pattern.compile( pattern );
  Matcher m = p.matcher( text );
  StringBuilder sb = new StringBuilder();
  while( m.find() )
  {
     sb.append( m.group() );
  }
  String result = sb.toString();
  System.out.println( "Result: '" + result + "'" );
}