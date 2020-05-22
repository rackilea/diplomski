Element root = new Element("exElement");
root.addNamespaceDeclaration("xsi","http://www.w3.org/2001/XMLSchema");
root.setNamespaceURI("urn:hl7-org:v3");

Document document = new Document(root);
System.out.println("XML :: " + document.toXML());