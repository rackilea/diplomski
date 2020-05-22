public String replace(String str) {
    String[] words = str.split(" ");
    StringBuilder sentence = new StringBuilder(words[0]);

    for (int i = 1; i < words.length; ++i) {
        sentence.append("%20");
        sentence.append(words[i]);
    }

    return sentence.toString();
}