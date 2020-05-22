public static String repl(String word, int y) {
    if (y <= 0) {
        return null;
    } else {
        System.out.print(repl(word, y - 1));
    }

    return word;
}