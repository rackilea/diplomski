Connection connection = DriverManager.getConnection("url");
File file = new File(fileURL);
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
Document docDom = db.parse(file);
NodeList list = docDom.getElementsByTagName("app");
String appInsertForamt = "INSERT INTO app(%s) VALUES (%s);";
String[] attributes = { "hash", "name", "package", "version", "filesize", "create_date" };
String[] values = new String[attributes.length];
for (int i = 0; i < list.getLength(); i++) {
    NamedNodeMap map = list.item(i).getAttributes();
for (int j = 0; j < attributes.length; j++) {
    values[j] = map.getNamedItem(attributes[j]).toString().replaceFirst(".*=", "");
    }
    String cols = Arrays.toString(attributes).replaceAll("\\[|\\]", "");
    String vals = Arrays.toString(values).replaceAll("\\[|\\]", "");
    String query = String.format(appInsertForamt, cols, vals);
    Statement statement = connection.createStatement();
    statement.executeUpdate(query);
}