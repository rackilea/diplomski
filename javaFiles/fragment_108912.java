public class CSVReader {
    private static final String DEFAULT_SEPARATOR = ",";
    private BufferedReader reader;
    private List<String> lines;

    public CSVReader(File file) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(file));

        lines = this.reader.lines().collect(Collectors.toList());
    }

    public String[] getRow(int rowNumber) {
        return lines.get(rowNumber).split(DEFAULT_SEPARATOR);
    }

    public int getRowCount() {
        return lines.size();
    }
}