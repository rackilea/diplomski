public static String NodeToString(String file,String moid) throws   SAXException, IOException, ParserConfigurationException{
String stringNode="";
InputStream in = new ByteArrayInputStream(file.getBytes("ISO-8859-1"));
Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
NodeList nodeList = doc.getElementsByTagName("*");
for (int i = 0; i < nodeList.getLength(); i++) {
    if(nodeList.item(i) instanceof Element && ((Element)nodeList.item(i)).getAttribute("MOID").equalsIgnoreCase(moid)){

try
{

  // Set up the output transformer
  TransformerFactory transfac = TransformerFactory.newInstance();
  Transformer trans = transfac.newTransformer();
  trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
  trans.setOutputProperty(OutputKeys.INDENT, "yes");

  // Print the DOM node

  StringWriter sw = new StringWriter();
  StreamResult result = new StreamResult(sw);
  DOMSource source = new DOMSource(nodeList.item(i));
  trans.transform(source, result);
  stringNode = sw.toString();

  //System.out.println(xmlString);
}
catch (TransformerException e)
{
  e.printStackTrace();
}       


    }
}
return stringNode;

 }