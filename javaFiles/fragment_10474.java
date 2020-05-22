public static String repeater(int x, String word) {
    if (x == 0) {
        return "";
    } else {
        return word.charAt(0) + repeater(x - 1, word);
    }
}