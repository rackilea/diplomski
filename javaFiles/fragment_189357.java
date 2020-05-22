DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = factory.newDocumentBuilder();
Document doc = dBuilder.parse("D:/test.xml");
doc.getDocumentElement().normalize();
Element element = doc.getDocumentElement(); 
System.out.println(element); // picks up the root element