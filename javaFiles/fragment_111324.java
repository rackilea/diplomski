public String startWord(String str, String word) {
    if (str.substring(1, word.length()).equals(word.substring(1, word.length()))) {
        return str.substring(0, word.length);
    } else {
        return "";
    }
}