package xsltplayground;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;

public class XSLTplayground {

    public static void main(String[] args) throws Exception {

        URL url = XSLTplayground.class.getResource("sample.xml");
        File input = new File(url.toURI());
        URL url2 = XSLTplayground.class.getResource("stylesheet.xsl");
        File xslt = new File(url2.toURI());
        URL url3 = XSLTplayground.class.getResource(".");
        File output = new File(url3.toURI());
        change(input, output, xslt);

    }

    private static void change(File pathIn, File directoryOut, File xsltFile) throws InterruptedException {
        try {

            // Creating a StAX event reader from the input
            XMLInputFactory xmlIf = XMLInputFactory.newFactory();
            XMLEventReader reader = xmlIf.createXMLEventReader(new StreamSource(pathIn));

            // Create a StAX output factory
            XMLOutputFactory xmlOf = XMLOutputFactory.newInstance();

            int counter = 1;
            // Keep going until no more events
            while (reader.hasNext()) {
                // Peek into the next event to find out what it is
                XMLEvent next = reader.peek();
                // If it's the start of a featureMember element, commence output
                if (next.isStartElement() 
                        && next.asStartElement().getName().getLocalPart().equals("featureMember")) {
                    File output = new File(directoryOut, "output_" + counter + ".xml");
                    try (OutputStream ops = new FileOutputStream(output)) {
                        XMLEventWriter writer = xmlOf.createXMLEventWriter(ops);
                        copy(reader, writer);
                        writer.flush();
                        writer.close();
                    }
                    counter++;
                } else {
                    // Not in a featureMember element: ignore
                    reader.next();
                }
            }

        } catch (XMLStreamException ex) {
            Logger.getLogger(XSLTplayground.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XSLTplayground.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private static void copy(XMLEventReader reader, XMLEventWriter writer) throws XMLStreamException {

        // Creating an XMLEventFactory
        XMLEventFactory ef = XMLEventFactory.newFactory();
        // Writing an XML document start
        writer.add(ef.createStartDocument());

        int depth = 0;
        boolean stop = false;
        while (!stop) {
            XMLEvent next = reader.nextEvent();
            writer.add(next);
            if (next.isStartElement()) {
                depth++;
            } else if (next.isEndElement()) {
                depth--;
                if (depth == 0) {
                    writer.add(ef.createEndDocument());
                    stop = true;
                }
            }
        }

    }

}