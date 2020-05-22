final Enumeration<URL> urls =
  getClass().getClassLoader().getResources("META-INF/aop.xml");

final Collection<String> aspectNames = new ArrayList<String>();

for (final URL url : urls) 
{
    final Stream xml = url.openStream();

    final DocumentBuilderFactory docBuilderFactory = 
      DocumentBuilderFactory.newInstance();
    docBuilderFactory.setValidating(false);
    docBuilderFactory.setNamespaceAware(false);

    final XPath xpath = XPathFactory.newInstance().newXPath();
    final Document aspectXml = docBuilderFactory.newDocumentBuilder().parse(xml);
    final XPathExpression selector = xpath.compile("//aspect/@name");

    final NodeList matches = 
      (NodeList) selector.evaluate(aspectXml, XPathConstants.NODESET);

    for (int i = 0; i < matches.getLength(); i++) 
    {
        aspectNames.add(matches.item(i).getNodeValue());
    }    
}