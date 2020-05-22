public static void main(String[] args){
    File file=new File(XmlProcessing.class.getResource("InputXml.txt").getFile());
    // create a new DocumentBuilderFactory
      DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
      try{
    DocumentBuilder  docBuilder = docBuilderFactory.newDocumentBuilder();
    Document document = docBuilder.parse(file);
    System.out.println("Before removing the Node:-");
    printDocument(document, System.out);
    NodeList tagList = document.getElementsByTagName("tag_name");
        Element elemToBeRemoved = (Element)tagList.item( 0 );
        Node prevElem = elemToBeRemoved.getPreviousSibling();
        if (prevElem != null && 
            prevElem .getNodeType() == Node.TEXT_NODE &&
            prevElem .getNodeValue().trim().length() == 0) {
            elemToBeRemoved.getParentNode().removeChild(prevElem );
        }
        elemToBeRemoved.getParentNode().removeChild( elemToBeRemoved );  
       System.out.println("\nAfter removing the node:-");
        printDocument(document, System.out);


      }catch(Exception excep){
          excep.printStackTrace();
      }

}
public static void printDocument(Document doc, OutputStream out) throws IOException, TransformerException {
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

    transformer.transform(new DOMSource(doc), 
         new StreamResult(new OutputStreamWriter(out, "UTF-8")));
}


/** Output:-
Before removing the Node:-
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<root>
    <tag_name>text</tag_name>
    <tag_name>text</tag_name>
    <tag_name>text</tag_name>
</root>

After removing the node:-
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<root>
    <tag_name>text</tag_name>
    <tag_name>text</tag_name>
</root>

*/