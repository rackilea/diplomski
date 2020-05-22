public class Test {
    public static void main(String[] args) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("test.xml");
        XPathFactory xPathFactory = XPathFactory.newInstance();
        writer.append(xPathFactory.newXPath().compile("//note/to").evaluate(document));
        writer.newLine();
        writer.append(xPathFactory.newXPath().compile("//note/from").evaluate(document));
        writer.newLine();
        writer.append(xPathFactory.newXPath().compile("//note/head").evaluate(document));
        writer.newLine();
        writer.append(xPathFactory.newXPath().compile("//note/body").evaluate(document));
        writer.newLine();
        writer.close();
    }
}