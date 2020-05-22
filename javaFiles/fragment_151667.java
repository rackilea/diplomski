public class FileParserExample {
    private Pattern pattern = Pattern.compile("([a-zA-Z]{2})(\\d+)");
    private Scanner reader;


    public FileParserExample(String filename) throws FileNotFoundException {
        reader = new Scanner(new File(filename));
    }

    public boolean hasMoreData() {
        String textFound = reader.findWithinHorizon(pattern, 0);
        return textFound != null;
    }

    public String[] getNextData() {
        MatchResult match = reader.match();
        String [] pieces = {match.group(1), // AB
                            match.group(2) }; // 123
        return pieces;
    }

    public void close() {
        reader.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "mydata.txt";
        FileParserExample parser = new FileParserExample(filename);

        while (parser.hasMoreData()) {
            System.out.println(Arrays.toString(parser.getNextData()));
        }

        parser.close();

    }
}