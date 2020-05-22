public static String reverseWords(String str) {
    StringBuilder sb = new StringBuilder(str.length() + 1);
    String[] words = str.split(" ");
    for (int i = words.length - 1; i >= 0; i--) {
        sb.append(words[i]).append(' ');
    }
    sb.setLength(sb.length() - 1);  // Strip trailing space
    return sb.toString();
}