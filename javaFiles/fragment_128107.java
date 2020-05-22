import com.google.common.collect.*;

public class Main {

    TreeMultimap<Integer, IndexEntry> entries = TreeMultimap.<Integer, IndexEntry>create(Ordering.arbitrary(), Ordering.natural().reverse());

    public static void main(String[] args) {
        // Add elements to `entries`

        // Get the most frequent word in document #1
        String mostFrequentWord = entries.get(1).first().getWord();
    }

}

class IndexEntry implements Comparable<IndexEntry> {

    private String word;

    private int frequency;

    private int documentId;

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getDocumentId() {
        return documentId;
    }

    @Override
    public int compareTo(IndexEntry i) {
        return Integer.compare(frequency, i.frequency);
    }

}