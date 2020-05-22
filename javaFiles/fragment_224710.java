XMLInputFactory inputFactory = XMLInputFactory.newInstance();
inputFactory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);
try
{
    XMLStreamReader streamReader = inputFactory
        .createXMLStreamReader(DocumentTest.class.getClassLoader().getResourceAsStream("xxmsg.xml"));
    while (streamReader.hasNext())
    {
        int next = streamReader.next();
        if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT)
        {
            if (streamReader.getLocalName().equals("Header"))
            {
                JAXBContext context = JAXBContext.newInstance(XXHeader.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                XXHeaderXMLReader xxHeaderXMLReader = new XXHeaderXMLReader(streamReader);
                XXHeader xxHeader =
                    unmarshaller.unmarshal(xxHeaderXMLReader, SBIsoHeader.class).getValue();
                System.out.println(xxHeader);
                break;
            }
        }
    }
}
catch (XMLStreamException e)
{
    e.printStackTrace();
}
catch (JAXBException e)
{
    e.printStackTrace();
}