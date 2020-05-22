public static String reverseWords(String sentence) {
    String[] words = sentence.split("\\s+");
    StringBuilder buf = new StringBuilder(sentence.length());

    for (int i = words.length - 1; i >= 0; i--) {
        if (buf.length() > 0)
            buf.append(' ');
        buf.append(words[i]);
    }

    return buf.toString();
}