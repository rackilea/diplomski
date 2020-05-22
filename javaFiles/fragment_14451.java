String xml = "<response>\n" +
             "<returnCode>-2</returnCode>\n" +
             "<error>\n" +
             "<errorCode>100</errorCode>\n" +
             "<errorMessage>ERROR HERE!!!</errorMessage>\n" +
             "</error>\n" +
             "</response>";
Document doc = DocumentBuilderFactory.newInstance()
                                     .newDocumentBuilder()
                                     .parse(new InputSource(new StringReader(xml)));

NodeList errNodes = doc.getElementsByTagName("error");
if (errNodes.getLength() > 0) {
    Element err = (Element)errNodes.item(0);
    System.out.println(err.getElementsByTagName("errorMessage")
                          .item(0)
                          .getTextContent());
} else { 
        // success
}