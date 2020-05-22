import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
  static List<String> findWordsThatContainAllCharsInSubString(String sentence, String subString) {
    List<String> wordMatches = new ArrayList<>();
    for (String word : sentence.split(" ")) {
      if (containsAllChars(word, subString)) {
        wordMatches.add(word);
      }
    }
    return wordMatches.size() > 0 ? wordMatches : null;
  }

  static boolean containsAllChars(String word, String subString) {
    if (word.length() < subString.length()) {
      return false;
    }
    Map<Character, Integer> subStringCharsMap = new HashMap<>();
    for (char c : subString.toCharArray()) {
      subStringCharsMap.put(c, subStringCharsMap.getOrDefault(c, 0) + 1);
    }
    for (char c : word.toCharArray()) {
      if (subStringCharsMap.containsKey(c)) {
        if (subStringCharsMap.get(c) == 1) {
          subStringCharsMap.remove(c);
        } else {
          subStringCharsMap.put(c, subStringCharsMap.get(c) - 1);
        }
      }
      if (subStringCharsMap.size() == 0) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String sentence = "I got a new pair of shoes";
    String subString = "hes";
    List<String> foundWords = findWordsThatContainAllCharsInSubString(sentence, subString);
    if (foundWords != null) {
      System.out.println(foundWords);
    } else {
      System.out.println(subString + " was not found in any word.");
    }
  }
}