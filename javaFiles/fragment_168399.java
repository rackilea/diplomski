public class CustomReader {

    public CustomReader(String inFile) throws FileNotFoundException {
        try (Scanner scan = new Scanner(inFile)) {
            while (scan.hasNextLine()) {
                // blah blah blah
            }
        }
    }
}