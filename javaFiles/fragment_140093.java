TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(new File("F:/Backup Files/testng2.xml").getAbsolutePath());        
    transformer.transform(source, result);
    System.out.println("File saved successfully");