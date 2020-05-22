String query = "//*[@name= 'Critic User']";
XPathExpression<Element> xpe = XPathFactory.instance().compile(query, Filters.element());
for (Element urle : xpe.evaluate(mydoc)) 
{
    System.out.printf("This Element has name '%s' and text '%s'\n",
          urle.getName(), urle.getValue());
}