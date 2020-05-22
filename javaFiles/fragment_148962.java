public static void main (String[] args) throws java.lang.Exception
{
    URL observationsUrl = new URL("http://open.live.bbc.co.uk/weather/feeds/en/2656397/observations.rss");
    Document observations = readXml(observationsUrl.openConnection().getInputStream());

    XPathFactory xpf = XPathFactory.newInstance();
    XPath xpath = xpf.newXPath();

    String title = xpath.evaluate("/rss/channel/title", observations);
    System.out.println(title);

    XPathExpression rssitemsExpr = xpath.compile("/rss/channel/item");

    NodeList items = (NodeList)rssitemsExpr.evaluate(observations, XPathConstants.NODESET);
    for (int i = 0; i < items.getLength(); i++) {
        System.out.println(xpath.evaluate("./title", items.item(i)));
    }
}