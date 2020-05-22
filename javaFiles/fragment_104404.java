public class XPathReader {
  private XPath xPath;
  private Document doc;

  public XPathReader(Clob xmlClob) {

    try {
        if ((int) xmlClob.length() > 0) {  
            String s = xmlClob.getSubString(1, (int) xmlClob.length()); // this is a way to cast a CLOB into a STRING
            doc = readDoc(s);
          }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    xPath = XPathFactory.newInstance().newXPath();
}

public Object read(String expression, QName returnType) {
    try {
        XPathExpression xPathExpression = xPath.compile(expression);
        return xPathExpression.evaluate(doc, returnType);
    } catch (XPathExpressionException ex) {
        ex.printStackTrace();
        return null;
    }
}

public Document readDoc(String s)
{
    Document d = null;
    try
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(s));
        d = builder.parse(is);
    } catch (Exception e)
    {
    }
    return d;
}