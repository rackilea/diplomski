class Main {
  static String findWordThatMatchesSubString(String sentence, String subString) {
    for (String word : sentence.split(" ")) {
      if (word.contains(subString)) {
        return word;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    String sentence = "Old man sneezed at Starbucks.";
    String subString = "nee";
    String foundWord = findWordThatMatchesSubString(sentence, subString);
    if (foundWord != null) {
      System.out.println(foundWord);
    } else {
      System.out.println(subString + " was not found in any word.");
    }

  }
}