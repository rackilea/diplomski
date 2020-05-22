...
catch (SAXParseException e)
{
    Element curElement = (Element)validator.getProperty("http://apache.org/xml/properties/dom/current-element-node");

    System.out.println("Validation error: " + e.getMessage());
    System.out.println("Element: " + curElement);
}