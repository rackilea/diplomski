public class RegExpPattern_002 {

   public static void main( String[] args ) {
      final String text =
         "hi [user=1234]John Jack[/user] take me home."
         + " [user=12] Jonno Ha [/user]"
         + " where you are [differentTag] hm? [/differentTag]."
         + " Peter Im here with [user=1]Danny Di [/user]";
      final Pattern p = Pattern.compile(
         "([^\\[]*)\\[(\\w+)(=([^\\]]+))?\\]([^\\[]*)\\[/(\\w+)\\]" );
      final Matcher m = p.matcher( text );
      while( m.find()) {
         final String preText   = m.group( 1 );
         final String attrOpen  = m.group( 2 );
         final String value     = m.group( 4 );
         final String content   = m.group( 5 );
         final String attrClose = m.group( 6 );
         assert attrClose.equals( attrOpen );
         System.err.printf(
            "pre = '%s', attr = '%s', value = '%s', content = '%s'\n",
            preText, attrOpen, value, content );
         System.err.println("-----------------------------");
      }
   }
}