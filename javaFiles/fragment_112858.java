public class Main {
    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    public static String TEST_XML_STRING = null;

    public static void main(String[] args) throws IOException {
        File file = new File("teste.xml");
        FileInputStream fin = new FileInputStream(file);
        byte[] xmlData = new byte[(int) file.length()];
        fin.read(xmlData);
        fin.close();
        TEST_XML_STRING = new String(xmlData, "UTF-8");

        try {
            JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);

            String jsonPrettyPrintString = xmlJSONObj
                    .toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);

        } catch (JSONException e) {
            System.out.println(e.toString());
        }

    }
}