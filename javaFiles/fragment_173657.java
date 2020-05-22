public class JSONReader {
    static JSONArray dictarray;

    public void init()  throws FileNotFoundException, ParseException, IOException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("C:\\Users\\Mohsen\\Documents\\NetBeansProjects\\DSFP2\\dictionary.JSON"));
        dictarray = (JSONArray)obj;
    }

    public Object read() {
      return dictarray.get(0);
    }
}