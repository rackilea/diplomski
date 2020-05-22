public class XMLToDatabase {

    private static int __SectorID;
    private static int __IndustryID;
    private static String __IndustryName;

    public static void main(String[] args) throws SQLException,
            UnsupportedEncodingException, ParserConfigurationException,
            SAXException, IOException, XPathExpressionException {

        try {
            File _XMLFile = new File("C:/Users/Sachin/Desktop/SectorsAndIndustries.xml");
            DocumentBuilderFactory _DocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder _DocumentBuilder = _DocumentBuilderFactory.newDocumentBuilder();
            Document _Document = _DocumentBuilder.parse(_XMLFile);
            _Document.getDocumentElement().normalize();

            XPath _XPath = XPathFactory.newInstance().newXPath();

            NodeList _NodeList1 = (NodeList) _XPath.evaluate("/results/sector", _Document, XPathConstants.NODESET);

            for (int i = 0; i < _NodeList1.getLength(); i++) {
                Element _Element1 = (Element) _NodeList1.item(i);

                __SectorID = Integer.parseInt(_Element1.getAttribute("sectorid"));

                NodeList _NodeList2 = (NodeList) _XPath.evaluate("industry", _Element1, XPathConstants.NODESET);

                for (int k=0; k < _NodeList2.getLength(); k++) {
                    __IndustryID = Integer.parseInt(_XPath.evaluate("industry[position()=" + (k + 1) + "]/@id", _Element1));
                    __IndustryName = _XPath.evaluate("industry[position()=" + (k + 1) + "]/@name", _Element1);

                    System.out.println(__SectorID + ", " + __IndustryID + ", " + __IndustryName);
                }
                System.out.println("\n-----------\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}