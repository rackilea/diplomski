public boolean check(ArrayList<Character> words, ArrayList<Character> wanted) {
    for (Character chr : wanted) {
        words.remove(chr);
    }
    return words.isEmpty();
}