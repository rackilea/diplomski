public class TextFileForStatus {

    private final String fileName = "status";
    private final String Format = "UTF-8";
    private BufferedReader reader = null;
    private PrintWriter writer = null;
    private boolean fileExists; // flag

    public TextFileForStatus() throws FileNotFoundException, UnsupportedEncodingException {
        fileExists = new File(fileName).exists();
        writer = new PrintWriter(fileName, Format);
        reader = new BufferedReader(new FileReader(fileName));
    }

    public void writeToFile(String currentStatus) {
        if (fileExists) {
            writer.println(currentStatus);
            System.out.println("writer wrote: " + currentStatus + " to file");
            writer.flush();
        }
    }

    public String readIndex() throws IOException {
        if (!fileExists) return "";

        String indexInFile = "";
        while ((indexInFile = reader.readLine()) != null) {
            indexInFile += reader.readLine();
        }
        return indexInFile;
    }
}