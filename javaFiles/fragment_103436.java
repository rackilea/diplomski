public static void main(String[] args) throws ParserConfigurationException,
            SAXException, IOException, XPathExpressionException {
        String xml = "<album position=\"1\"><artist>Cher</artist><title>Believe</title><mbid>61bf0388-b8a9-48f4-81d1-7eb02706dfb0</mbid><url>http://www.last.fm/music/Cher/Believe</url><image size=\"small\">http://userserve-ak.last.fm/serve/34/8674593.jpg</image><image size=\"medium\">http://userserve-ak.last.fm/serve/64/8674593.jpg</image><image size=\"large\">http://userserve-ak.last.fm/serve/126/8674593.jpg</image></album>";

        InputStream stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document documento = builder.parse(stream);
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile("//album/image[@size='medium']");
        NodeList nlLastFm = (NodeList) expr.evaluate(documento,
                XPathConstants.NODESET);

        String coverUrl = nlLastFm.item(0).getTextContent();
        System.out.println(coverUrl);

    }