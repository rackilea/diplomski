String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<event id=\"370e7324-3-85ec-63dac16aacb6\">\n"
        + "<properties>\n" + "<property enc=\"BASE64\" name=\"state\" value=\"Hrthyw35WmnmewqzRlYXI=\"/>\n"
        + "<property enc=\"BASE64\" name=\"record\" value=\"mjhm65WmnmewqzRlYXI=\"/>\n"
        + "<property enc=\"BASE64\" name=\"application\" value=\"Q2FsZWmnmewqzRlYXI=\"/>\n" + "</properties>\n"
        + "</event>\n";

DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(new InputSource(new StringReader(xml)));
doc.getDocumentElement().normalize();
NodeList properties = doc.getElementsByTagName("property");

for (int index = 0; index < properties.getLength(); index++) {
    Node node = properties.item(index);
    Element element = (Element) node;
    if ("application".equals(element.getAttribute("name"))) {
        String name = element.getAttribute("name");
        String valueEncoded = element.getAttribute("value");
        String decoded = new String(Base64.getDecoder().decode(valueEncoded));
        System.out.println("--value--" + decoded);
    }
}