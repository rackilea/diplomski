private Element element;
 Document doc;

 public  void create(Instances instances) throws IOException, SAXException, ParserConfigurationException {
     assert instances!=null;
     DocumentBuilderFactory documentBuilderFactory = new DocumentBuilderFactoryImpl();
     DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
     assert builder != null;
     doc = builder.parse(instances.toString());
         element = (Element) doc;