public class OMTest {
    public static void main(String[] args) throws IOException {
        // test string
        String json = "  {\"a\" : \"b\", \"c\" : \"d\" } ";
        // mapper
        ObjectMapper mapper = new ObjectMapper();
        // json tree
        JsonNode tree = mapper.readTree(json);
        // the objectWriter assigned with a pretty printer
        ObjectWriter myWriter = mapper.writer(new DefaultPrettyPrinter());
        // print without pretty printer (using mapper)
        System.out.println(mapper.writeValueAsString(tree));
        System.out.println();
        // print with writer (using the pretty printer) 
        System.out.println(myWriter.writeValueAsString(tree));
    }
}