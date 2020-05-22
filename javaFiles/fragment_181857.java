public class Parser {

    public  List<String> getListOfAirportsFromCsvAsAStrings(InputStream inputCsvData) {
        List<String> airportsAsAStringFromCsvFile = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputCsvData))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                airportsAsAStringFromCsvFile.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return airportsAsAStringFromCsvFile;
    }
}