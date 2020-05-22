try {
     File inputOne = new File("first.xml");
     File inputTwo = new File("second.xml");

     DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
     DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
     Document docOne = dBuilder.parse(inputOne);
     Document docTwo = dBuilder.parse(inputTwo);
     NodeList nodeListAhmed = docTwo.getElementsByTagName("ahmed");

     for (int i = 0; i < nodeListAhmed.getLength(); i++) {
         Node nodeMohamed = docTwo.importNode(docOne.getElementsByTagName("mohamed").item(0), true);
         nodeListAhmed.item(i).appendChild(nodeMohamed);
     }

     DOMSource source = new DOMSource(docTwo);
     TransformerFactory transformerFactory = TransformerFactory.newInstance();
     Transformer transformer = transformerFactory.newTransformer();
     StreamResult result = new StreamResult("output.xml");
     transformer.transform(source, result);

} catch (Exception e) {
     e.printStackTrace();
}