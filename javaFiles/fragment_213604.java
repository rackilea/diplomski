public class ContactDetailRetriever {
    private static final String DEFAULT_FILE_NAME = "contacts.txt";
    private final String fileName;
    private final FileLinesReader fileLinesReader;

    public ContactDetailRetriever() {
        this(DEFAULT_FILE_NAME);
    }

    public ContactDetailRetriever(String fileName) {
        this(fileName, new DefaultFileLinesReader());
    }

    // Visible for testing
    ContactDetailRetriever(String fileName, FileLinesReader fileLinesReader) {
        this.fileName = fileName;
        this.fileLinesReader = fileLinesReader;
    }

    public List<String> retrieveContactDetails() {
        return fileLinesReader.readAllLines(fileName);
    }

    public Map<String, String> mapOfContact() {
        List<String> details = retrieveContactDetails();
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < details.size() - 1; i += 2) {
            result.put(details.get(i), details.get(i + 1));
        }
        return result;
    }

    public interface FileLinesReader {
        public List<String> readAllLines(String filename);
    }

    private static class DefaultFileLinesReader implements FileLinesReader {
        public List<String> readAllLines(String filename) {
            try {
                return Files.readAllLines(Paths.get(filename));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}