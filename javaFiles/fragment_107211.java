String inputXml = "<root><value>Test</value></root>";

// Build DOM tree for input XML
DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder domBuilder = domFactory.newDocumentBuilder();
Document document = domBuilder.parse(new InputSource(new StringReader(inputXml)));

// Print DOM XML using default settings
TransformerFactory transformerFactory = TransformerFactory.newInstance();
Transformer transformer = transformerFactory.newTransformer();
transformer.transform(new DOMSource(document), new StreamResult(System.out));

System.out.println();   System.out.println();

// Print DOM XML using specific settings
document.setXmlVersion("1.1");
transformer.setOutputProperty(OutputKeys.ENCODING, "windows-1252");
transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "ROOT-VALUE");
transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "RootValue.dtd");
transformer.transform(new DOMSource(document), new StreamResult(System.out));