public class CSVReaderw {

    public static void main(String[] args) {

        String adDotCsv = "/Users/Documents/AD.csv";
        String databaseDotCsv = "/Users/Desktop/database.csv";
        String line = "";
        String cvsSplitBy = ",";
        BufferedReader br = null;
        List<String> databaseList = new ArrayList<>();
        List<String[]> adList = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(databaseDotCsv));

            while ((line = br.readLine()) != null) {
                databaseList.addAll(Arrays.asList(line.split(cvsSplitBy)));
            }

            br = new BufferedReader(new FileReader(adDotCsv));

            line = "";
            while ((line = br.readLine()) != null) {
                adList.add(line.split(cvsSplitBy));
            }

            List<String[]> commonList = new ArrayList<>();

            String cellCInAdFile = null;

            for (String[] rowInAdList : adList) {
                cellCInAdFile = Arrays.toString(rowInAdList).split(",")[2].trim();

                for (String cellAinDatabaseFile : databaseList) {
                    if (cellCInAdFile.equals(cellAinDatabaseFile.trim())) {
                        commonList.add(rowInAdList);
                    }
                }
            }

            for (String[] rowInCommonList : commonList) {
                System.out.println(Arrays.asList(rowInCommonList));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}