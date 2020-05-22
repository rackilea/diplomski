public class OffersUrlChecker {

    private static final String SAMPLE_CSV_FILE_PATH = "d:\\LENAL\\ZUD\\load\\offers.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)
        ) {
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                String url = csvRecord.get(0);
                URL myUrl = new URL(url);
                HttpURLConnection myUrlCon = null;
                try {
                    myUrlCon = (HttpURLConnection) myUrl.openConnection();
                    int code = myUrlCon.getResponseCode();
                    System.out.println(csvRecord.getRecordNumber() + " - " + code + " " + url);
                } catch (Exception e) {
                    Logger.getLogger(OffersUrlChecker.class.getName()).log(Level.SEVERE,
                            String.format("Could not read from %s", url), e);
                    // sleep a bit
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e1) {
                        Logger.getLogger(OffersUrlChecker.class.getName()).log(Level.WARNING,
                                "Sleep interrupted", e);
                    }
                } finally {
                    if (myUrlCon != null) {
                        myUrlCon.disconnect(); // Make sure you close the sockets
                    }
                }
            }
        }
    }
}