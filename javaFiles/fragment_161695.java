public class Dictionary {
    private Map<String, DictionaryEntry> entries;

    public Dictionary(InputStream corpus) throws IOException {
        this.entries = new HashMap<String, DictionaryEntry>();
        // Read the corpus and populate the map here.
    }

    public DictionaryEntry lookup(String term) { 
        return this.entries.get(term);
    }
}