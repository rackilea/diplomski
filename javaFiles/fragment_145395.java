DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
docFactory.setNamespaceAware(true); // webRequest needs a namespace
DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

Document doc = docBuilder.newDocument();
Element root = doc.createElementNS("http://____________", "webRequest");
doc.appendChild(root);

Element argElement = doc.createElement("arg0");
root.appendChild(argElement);
String message = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<Interface Code=\"20\" \n      <Transaction Txn=\"01880120121024000001\" CD=\"01880120121024000001001\" \n     Date=\"2012-10-24 17:27:25\"  BirthDate=\"1983-03-27\" Code=\"8110009000000720\" Type=\"0\"/>\n</Interface>";
argElement.setTextContent(message);

SOAPMessage request = MessageFactory.newInstance().createMessage();
request.getSOAPBody().addDocument(doc);
request.setProperty(SOAPMessage.WRITE_XML_DECLARATION, "true");
request.writeTo(System.out);