import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.XMLEvent;

public class XmlReader
{

public static void main(String[] args) throws XMLStreamException, IOException
{
    XMLParseAttribute("input.xml");
}

public static void XMLParseAttribute(String fileName) throws XMLStreamException, IOException
{

    XMLInputFactory inputFactory = XMLInputFactory.newInstance();
    InputStream in = new FileInputStream(fileName);
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
}}