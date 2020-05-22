public static void main(String[] args) {
    File xmlFile = new File("thor.xml");
    Document xmlDocument = DocumentBuilderFactory.newInstance()
          .newDocumentBuilder().parse(xmlFile);
    // this is effective because we know we're adding to the 
    // document root element
    // if you want to write to an arbitrary node, you must 
    // include code to find that node
    addTextElement(xmlDocument.getDocumentElement(), "C", "New");
    writeDoc(new FileWriter(xmlFile);
}

public static Element addTextElement(Node parent, String element, String val){
    Element e = addElement(parent, element)
    e.appendChild(xmlDocument.createTextNode(val));
    return e;
}

public static Element addElement(Node parent, String element){
    Element e = xmlDocument.createElement(path);
    parent.appendChild(e);
    return e;
}

public static void writeDoc(Writer writer) {
    try {
      Transformer tf = TransformerFactory.newInstance().newTransformer();
      tf.transform(new DOMSource(xmlDocument), new StreamResult(writer)); 
    } finally {
      writer.close();
    }
}