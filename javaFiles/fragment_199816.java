public static void main(String[] args) throws Exception {
    final String xml =    "<book> " +
        "<person> " +
          "<name>Person 1</name> " +
        "</person> " +
        "<person> " +
          "<name>Person 2</name> " +
        "</person> " +
        "<person> " +
          "<name>Person 3</name> " +
        "</person> " +
        "<person> " +
          "<name>Person 4</name> " +
        "</person> " +
      "</book>";

      DocumentBuilderFactory dbf =
          DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      InputSource is = new InputSource();
      is.setCharacterStream(new StringReader(xml));

      Document doc = db.parse(is);
      deletePerson(doc, "Person 3");
      printXML(doc);
  }

  public static void deletePerson(Document doc, String personName) {
    // <person>
    NodeList nodes = doc.getElementsByTagName("person");

    for (int i = 0; i < nodes.getLength(); i++) {
      Element person = (Element)nodes.item(i);
      // <name>
      Element name = (Element)person.getElementsByTagName("name").item(0);
      String pName = name.getTextContent();
      if (pName.equals(personName)) {
         person.getParentNode().removeChild(person);
      }
    }
  }

  public static void printXML(Document doc) 
  throws TransformerException {
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");

    StreamResult result = new StreamResult(new StringWriter());
    DOMSource source = new DOMSource(doc);
    transformer.transform(source, result);

    String xmlString = result.getWriter().toString();
    System.out.println(xmlString);
  }