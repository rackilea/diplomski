File fXmlFile = new File("test.xml");
     SAXBuilder builder = new SAXBuilder();
     Document document = builder.build(fXmlFile);
     Element beans = document.getRootElement();

     Element dbUrlElementHost = (Element) XPath.selectSingleNode(beans,"items/otherThing/prop3");
     dbUrlElementUsername.getValue()+"";