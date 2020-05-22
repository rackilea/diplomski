try {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    Document doc = dbf.newDocumentBuilder().parse(new File("Test.xml"));
    List<String> chapters = loadChapters(doc, "Quantitave Aptitude");
    for (String chapter : chapters) {
        System.out.println(chapter);
    }
} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException exp) {
    exp.printStackTrace();
}