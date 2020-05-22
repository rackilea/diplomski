public class DataAnalyzer {

    private List<Integer> rawFileData;

    public DataAnalyzer(String fileName) throws FileNotFoundException {

        rawFileData = new ArrayList<>();
        FileReader file = new FileReader(fileName);
        try (Scanner in = new Scanner(file)) {
            while (in.hasNext()) {
                rawFileData.add(in.nextInt());
            }
        }
    }

    public int getLargest() {
        return Collections.max(rawFileData);
    }

}

public class DataAnalyzerTester {

    public static void main(String[] args) throws FileNotFoundException {
        DataAnalyzer analizer = new DataAnalyzer("info.txt");
        System.out.println(analizer.getLargest());
    }

}