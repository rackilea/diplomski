public class CSVFileReaders {

    private final String csvFile;
    private HashMap<String, ArrayList<String>> cityMap;
    private final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String filePath = "C:\\worldcities1.csv";
        CSVFileReaders csvFileReaders = new CSVFileReaders(filePath);
        csvFileReaders.createCitiesMap();
        csvFileReaders.processUserFindRequest(); // First search
        csvFileReaders.processUserFindRequest(); // Second search
    }


    public CSVFileReaders(String csvFile) {
        this.csvFile = csvFile;
    }

    public void createCitiesMap() {
        cityMap = new HashMap<>();
        try (Scanner x = new Scanner(new File(csvFile), "UTF-8")) {
            String city = "";
            while (x.hasNextLine()) {
                ArrayList<String> values = new ArrayList<String>();
                String name = x.nextLine();
                //break each line of the csv file to its elements
                String[] line = name.split(",");
                city = line[1];
                for (int i = 0; i < line.length; i++) {
                    values.add(line[i]);
                }
                cityMap.put(city, values);
            }
            x.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void processUserFindRequest() {

        System.out.println(" \n Enter the City name to be Searched :   \n _> ");
        long start = System.currentTimeMillis();
        String searchTerm = in.nextLine();
        long end = System.currentTimeMillis();
        System.out.println(" \n It took " + (end - start) + " Milli Seconds to search the result \n");
        //Search the city
        if (cityMap.containsKey(searchTerm)) {
            System.out.println("City name is : " + searchTerm + "\nCity details are accordingly in the order :"
                                       + "\n[city , city_ascii , lat , lng , country , iso2 , iso3 , admin_name , capital , population , id] \n"
                                       + cityMap.get(searchTerm) + "");
        } else {
            System.out.println("Enter the correct City name");
        }
    }
}