static final Document doc;

static {
   DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
   doc = dBuilder.parse(file); 
}