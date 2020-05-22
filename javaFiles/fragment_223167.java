XmlSuite suite = new XmlSuite();
 suite.setName("TmpSuite");
 XmlTest test = new XmlTest(suite);
 test.setName("TmpTest");
 List<XmlClass> classes = new ArrayList<XmlClass>();
 classes.add(new XmlClass("test.failures.Child"));
 test.setXmlClasses(classes) ;