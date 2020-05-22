public class SortByFreq implements Comparator<Word> {
    @Override
    public int compare(Word w1, Word w2) {
        return Integer.compare(w2.getCount(), w1.getCount());
    }
}