String xml = "<message>HELLO!</message>";
org.jdom.input.SAXBuilder saxBuilder = new SAXBuilder();
try {
    org.jdom.Document doc = saxBuilder.build(new StringReader(xml));
    String message = doc.getRootElement().getText();
    System.out.println(message);
} catch (JDOMException e) {
    // handle JDOMException
} catch (IOException e) {
    // handle IOException
}