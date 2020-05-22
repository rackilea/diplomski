class XMLProcessor { //By the way, that is a terrible name, but I will let you deal with that.
  private static final String HOURS_XPATH = "/dwml/data/time-layout[3]/start-valid-time/text()";
  private XPathFactory xPathfactory = XPathFactory.newInstance();
  private XPathExpression hourly;

  public XMLProcessor(String url) {
    XPath xpath = xPathfactory.newXPath(); 
    hourly = xpath.compile(HOURS_XPATH); 
  }   

  public List<String> getHours() {
    //Pass hourly to toNodeList and turn it to an ArrayList
    //Provide similar methods for all the other data sets you want to extract and provide
  }

  private NodeList toNodeList(XPathExpression exp) {
    //to be reused for all the conversions
    return (NodeList) exp.evaluate(doc,XPathConstants.NODESET);
  }
}