static class SortByFreqAndAlphabetically implements Comparator<Word> {
    @Override
    public int compare(Word w1, Word w2) {
        if (w1.getCount() != w2.getCount()) {
            return Integer.compare(w2.getCount(), w1.getCount());
        } else {
            return w1.getWord().compareTo(w2.getWord());
        }
    }
}