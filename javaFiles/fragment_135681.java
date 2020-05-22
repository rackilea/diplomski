public MyObject parseXML(String xml)
    throws XMLStreamException, UnsupportedEncodingException
{
    byte[] byteArray = xml.getBytes("UTF-8");
    ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
    XMLInputFactory inputFactory = XMLInputFactory.newInstance();
    XMLEventReader reader = inputFactory.createXMLEventReader(inputStream);

    MyObject object = new MyObject();

    while (reader.hasNext())
    {
        XMLEvent event = (XMLEvent) reader.next();

        if (event.isStartElement())
        {
            StartElement element = event.asStartElement();

            if (element.getName().getLocalPart().equals("ElementOne"))
            {
                event = (XMLEvent) reader.next();

                if (event.isCharacters())
                {
                     String elementOne = event.asCharacters().getData();
                     object.setElementOne(elementOne);
                }
                continue;
            }
            if (element.getName().getLocalPart().equals("ElementTwo"))
            {
                event = (XMLEvent) reader.next();
                if (event.isCharacters())
                {
                     String elementTwo = event.asCharacters().getData();
                     object.setElementTwo(elementTwo);
                }
                continue;
            }
        }
    }

    return object;
}