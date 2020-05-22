if(Files.exists(path)) { 
      document = documentBuilder.parse("Bday.xml");
      element = document.getDocumentElement();
}
else{
      document = documentBuilder.newDocument();
      element = document.createElement("Birthday");
      document.appendChild(element);
}
Element Id = document.createElement("Id");

Id.appendChild(document.createTextNode(Integer.toString(serialNumber)));
element.appendChild(Id);

Element xmlName = document.createElement("Name");
xmlName.appendChild(document.createTextNode(name));
Id.appendChild(xmlName);

Element xmldateOfBirth = document.createElement("Date_Of_Birth");
xmldateOfBirth.appendChild(document.createTextNode(dateOfBirth));
Id.appendChild(xmldateOfBirth);

DOMSource source = new DOMSource(document);
transformerFactory = TransformerFactory.newInstance();
transformer = transformerFactory.newTransformer();
transformer.setOutputProperty(OutputKeys.INDENT, "yes");

StreamResult streamResult = new StreamResult(new File("Bday.xml"));
transformer.transform( source, streamResult );