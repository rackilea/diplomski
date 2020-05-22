public static String getNumberString( String s)
 {
     String word = s;
     String word1 = word.replaceAll("[AEIOUaeiou]", "@");
     int c = 0;

     String word2 =  word1;
     for( c = 0; c <= word.length(); c++)
     {
           word2 = word2.replaceFirst("@", Integer.toString(c));
     }

     return word2;
 }