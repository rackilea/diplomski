ClassLoader classLoader = ClassLoader.getSystemClassLoader();
DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
domFactory.setIgnoringComments(true);
DocumentBuilder builder = domFactory.newDocumentBuilder();
Document doc = builder.parse(new File(classLoader.getResource("MyFolder/Test.xml").getPath()));
System.out.println(doc.getDocumentElement());