public class DataAnalyzerTester {

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Enter your fileName: ");
    }

    public void printLargest(DataAnalyzer rawFileData) {
        List<Integer> example = new ArrayList<Integer>();
        example.add(0);
        example.add(1);
        example.add(2);
        int result = rawFileData.getLargest(example);
        System.out.println(result);
    }
}