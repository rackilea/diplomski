public String[] reverseString(String[] words) {
    String[] t = new String[words.length];
    for (String wordTemp : words) {
      StringBuilder sb = new StringBuilder(wordTemp);
      t[i] = sb.reverse().toString();   
    }
    return t;
}