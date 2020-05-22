public static void XMLParseAttribute() throws XMLStreamException, IOException
{

    XMLInputFactory inputFactory = XMLInputFactory.newInstance();
    InputStream in = new FileInputStream("input.xml");
    XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
    XMLEvent event;

    while (eventReader.hasNext())
    {
        event = eventReader.nextEvent();

        if (event.isStartElement())
        {
            String elemntName = event.asStartElement().getName().getLocalPart();
            System.out.println(elemntName);
            Iterator<Attribute> iterator = event.asStartElement().getAttributes();
            while (iterator.hasNext())
            {
                Attribute attribute = iterator.next();
                String value = attribute.getValue();
                String name = attribute.getName().toString();
                System.out.println("\t" + name + " " + value);
            }
        }
    }
}