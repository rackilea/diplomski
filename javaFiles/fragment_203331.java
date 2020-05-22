public static int numberOfVowels(String aWord) {
    int num = 0;
    final String vowels = "aeiouAEIOU";

    for (int i = 0; i < aWord.length(); i++) {
      if (vowels.indexOf(aWord.substring(i, i+1)) != -1) {
        num++;
      }
    }

    return num;
}