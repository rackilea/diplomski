// use Jackson to read/write your data files in Json format
import com.fasterxml.jackson.databind.ObjectMapper;

public class Inverter {
    private JsonFileWriter fileWriter;

    /*
     * Don't use HashMap since it isn't sorted
     */
    Map<String, TermMetadata> dictionary = new HashMap<>();

    public List<File> invert(final Collection<Document> documents) {
    }

    public void writeDictionation() {
        fileWriter.write(dictionary);
    }

    public void writePostings() {
        fileWriter.write(postings);
    }
}

public class Document {
    /**
     * Index is the documentId
     */
    int documentId;

    // other attributes ...
}

public class TermMetadata {
    /*
     * Index on the term
     */
    String term;
    int documentFrequency;
    List<int> postingsIds;
}

public class Posting {
    /**
     * Index on the posting id
     */
    int postingId;
    int documentId;
    int termFrequency;
    List<int> positions;
}