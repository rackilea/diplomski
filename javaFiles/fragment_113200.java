class MenuContentHandler implements ContentHandler
{
    public XMLReader reader;
    public ItemContentHandler itemHandler;

    ...
    public void startElement(java.lang.String uri, java.lang.String localName,
        java.lang.String qName, Attributes atts)
    {
        if (localName.equals("items"))
            reader.setContentHandler(itemHandler); // Point 1
    }
    ...
    public void endElement(java.lang.String uri, java.lang.String localName,
        java.lang.String qName)
    {
        if (localName.equals("menu"))
            reader.setContentHandler(itemHandler); // Point 2
    }
    ...
}

class ItemContentHandler implements ContentHandler
{
    public XMLReader reader;
    public MenuContentHandler menuHandler;

    ...
    public void startElement(java.lang.String uri, java.lang.String localName,
        java.lang.String qName, Attributes atts)
    {
        if (localName.equals("menu"))
            reader.setContentHandler(menuHandler); // Point 3
    }
    ...
    public void endElement(java.lang.String uri, java.lang.String localName,
        java.lang.String qName)
    {
        if (localName.equals("items"))
            reader.setContentHandler(menuHandler); // Point 4
    }
    ...
}
...
void doParsing ( )
{
    XMLReader reader = XMLReaderFactory.createXMLReader();
    MenuContentHandler menuHandler = new MenuContentHandler(reader);
    ItemContentHandler itemHandler = new ItemContentHandler(reader);

    menuHandler.itemHandler = itemHandler;
    itemHandler.menuHandler = menuHandler;

    reader.setContentHandler(menuhandler);
    reader.parse (/*your document*/);
}