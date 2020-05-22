class LetterCount implements Comparable {

    char letter;
    int count;

    public String asString() {
        return letter + ":" + count;
    }

    @Override
    public int compareTo(Object t) {
        return ((LetterCount) t).count - count;
    }
}