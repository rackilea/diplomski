public class JSONReader {
    JSONArray dictarray;

    public void read()  throws FileNotFoundException, ParseException, IOException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("C:\\Users\\Mohsen\\Documents\\NetBeansProjects\\DSFP2\\dictionary.JSON"));
        dictarray = (JSONArray)obj;
    }
}