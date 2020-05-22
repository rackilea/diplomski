XPath xPath = XPathFactory.newInstance().newXPath();
String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
String expression = "//time[@day='" + timeStamp + "']/temperature";
try {
  NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(docm, XPathConstants.NODESET);
  Node nNodem = nodeList.item(0);
  if (nNodem.getNodeType() == Node.ELEMENT_NODE) {
    Element eElementm = (Element) nNodem;
    double dmax = Math.round(Double.parseDouble(eElementm.getAttribute("max")));
    int dxmax = (int) dmax;
    xmaxtemp = Integer.toString(dxmax);
    double dmin = Math.round(Double.parseDouble(eElementm.getAttribute("min")));
    int dxmin = (int) dmin;
    xmintemp = Integer.toString(dxmin);
  }
} catch (Exception e) {
  System.out.println(e);
}