import java.util.ArrayList;
import java.util.List;

class Main {
  static List<String> findWordsThatMatchesSubString(String sentence, String subString) {
    List<String> wordMatches = new ArrayList<>();
    for (String word : sentence.split(" ")) {
      if (word.contains(subString)) {
        wordMatches.add(word);
      }
    }
    return wordMatches.size() > 0 ? wordMatches : null;
  }

  public static void main(String[] args) {
    String sentence = "Old man sneezed at Starbucks and dropped his knitting needle on the floor.";
    String subString = "nee";
    List<String> foundWords = findWordsThatMatchesSubString(sentence, subString);
    if (foundWords != null) {
      System.out.println(foundWords);
    } else {
      System.out.println(subString + " was not found in any word.");
    }
  }
}