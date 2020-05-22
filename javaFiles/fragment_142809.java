public class XPathCheck {
    public static void main(String[] args) throws FileNotFoundException, IOException, XPathExpressionException {
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();

        try (InputStream file = new FileInputStream(Paths.get("src", "inputFile.xml").toFile())) {
            String strExprssion = "//urn:or-HourlyHistoricalPrice:HourlyHistoricalPrice[urn:or-HourlyHistoricalPrice:refSource='AIBO']";
            XPathExpression expression = xpath.compile(strExprssion);
            NodeList nodes = (NodeList) expression.evaluate(new InputSource(file), XPathConstants.NODESET);

            System.out.println(nodes.getLength());
        }
    }
}