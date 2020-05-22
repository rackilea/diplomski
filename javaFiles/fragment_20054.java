public static String detectAndConvertURLs(String text) {
   //Regex pattern (unescaped), matches any Internet URL: 
   //((mailto\:|(news|(ht|f)tp(s?))\://){1}\S+)
   Pattern p = Pattern.compile( "((mailto\\:|(news|(ht|f)tp(s?))\\://){1}\\S+)" );
   Matcher m = p.matcher( text );
   if( m.matches() ){
      return m.group(1);
   }else return null;
}