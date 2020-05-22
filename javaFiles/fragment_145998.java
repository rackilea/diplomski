DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
domFactory.setIgnoringComments(true);
DocumentBuilder builder = domFactory.newDocumentBuilder(); 
Document doc = builder.parse(new File("XmlTest.xml")); 

NodeList nodes = doc.getElementsByTagName("CustomerId");

Text a = doc.createTextNode("value"); 
Element p = doc.createElement("newNode"); 
p.appendChild(a); 

nodes.item(0).getParentNode().insertBefore(p, nodes.item(0));