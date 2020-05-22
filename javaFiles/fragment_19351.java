public class Main {
    public static void main(String[] args) throws IOException, SAXException {
        ArrayList<String> queries = new parser().getQueries("test.xml");
        for (String query : queries){
            System.out.println(query);
        }

    }
}