public class DuplicateEle {
    public static void main(String args[]) {
      Set<String> seen = new HashSet<>();
      String[] arr = { "hello", "hi", "hello", "howru" };

      for (String word : arr) {
        boolean unique = seen.add(word);
        System.out.printf("%s is duplicate: %b%n", word, !unique);
      }
    }
}