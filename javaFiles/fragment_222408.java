public class TestContains {

   private static String containsWord(Set<String> words,String sentence) {
     for (String word : words) {
       if (sentence.contains(word)) {
         return word;
       }
     }

     return null;
   }

   private static String matchesPattern(Pattern p,String sentence) {
     Matcher m = p.matcher(sentence);

     if (m.find()) {
       return m.group();
     }

     return null;
   }

   public static void main(String[] args) {
     Set<String> words = new HashSet<String>();
     words.add("apple");
     words.add("orange");
     words.add("pear");
     words.add("banana");
     words.add("kiwi");

     Pattern p = Pattern.compile("apple|orange|pear|banana|kiwi");

     String noMatch = "The quick brown fox jumps over the lazy dog.";
     String startMatch = "An apple is nice";
     String endMatch = "This is a longer sentence with the match for our fruit at the end: kiwi";

     long start = System.currentTimeMillis();
     int iterations = 10000000;

     for (int i = 0; i < iterations; i++) {
       containsWord(words, noMatch);
       containsWord(words, startMatch);
       containsWord(words, endMatch);
     }

     System.out.println("Contains took " + (System.currentTimeMillis() - start) + "ms");
     start = System.currentTimeMillis();

     for (int i = 0; i < iterations; i++) {
       matchesPattern(p,noMatch);
       matchesPattern(p,startMatch);
       matchesPattern(p,endMatch);
     }

     System.out.println("Regular Expression took " + (System.currentTimeMillis() - start) + "ms");
   }
}