XMLStreamWriter w = XMLOutputFactory.newInstance().createXMLStreamWriter(System.out);
try
{
    w.writeStartDocument();
    w.writeStartElement("root");
    for (int i = 0; i < 1000; i++)
    {
        w.writeStartElement("number");
        w.writeCharacters(String.valueOf(i));
        w.writeEndElement(); //number
    }
    w.writeEndElement(); //root
    w.writeEndDocument();
}
finally
{
    w.close();
}