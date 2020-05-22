import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XmlToCSV {

    public static void convert(InputStream xml, OutputStream csv) throws Exception {
        try (StringWriter header = new StringWriter(4096); StringWriter content = new StringWriter(4096)) {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader xmlEventReader = factory.createXMLEventReader(xml);
            XMLEvent xmlEvent;
            long nestingLevel = -1;
            StringBuilder line = null;
            while (xmlEventReader.hasNext()) {
                xmlEvent = xmlEventReader.nextEvent();
                switch (xmlEvent.getEventType()) {
                case XMLEvent.START_ELEMENT:
                    ++nestingLevel;
                    if (0 == nestingLevel) {
                        break;
                    } else if (1 == nestingLevel) {
                        line = new StringBuilder();
                    }
                    StartElement startElement = xmlEvent.asStartElement();
                    serializeElementHeader(header, line, startElement);
                    break;
                case XMLEvent.CHARACTERS:
                case XMLEvent.CDATA:
                    if (nestingLevel < 1)
                        break;
                    Characters chars = xmlEvent.asCharacters();
                    if (!chars.isWhiteSpace()) {
                        line.append(chars.getData());
                        line.append(',');
                    }
                    break;
                case XMLEvent.END_ELEMENT:
                    if (--nestingLevel == 0) {
                        header.write("0/");
                        for(int i= line.length()-1; ',' == line.charAt(i); --i) {                           
                            line.deleteCharAt(i);
                        }
                        content.write(line.toString());
                        content.write('\n');
                    }
                    break;
                default:
                    break;
                }
            }
            // write csv
            try (Writer cvsWriter = new OutputStreamWriter(csv, StandardCharsets.UTF_8.name())) {
                cvsWriter.write(header.toString());
                cvsWriter.write('\n');
                cvsWriter.write(content.toString());
            }
        }
    }

    private static void serializeElementHeader(StringWriter header, StringBuilder line,
            StartElement startElement) {
        header.write(startElement.getName().getLocalPart());
        header.write('/');
        Iterator<Attribute> it = startElement.getAttributes();
        while(it.hasNext()) {
            Attribute attr = it.next();
            header.write('_');
            header.write(attr.getName().getLocalPart());
            header.write('/');
            line.append(attr.getValue());
            line.append(',');
        }
    }

    private static String TEST_XML = "<?xml version='1.0'?>" 
            + "<Company>" 
            + "  <Employee id='1'>"
            + "      <Email>tp@xyz.com</Email>" 
            + "      <UserData id='id32' type='AttributesInContext'>"
            + "         <UserValue value='7in' title='Heigh'></UserValue>"
            + "         <UserValue value='' title='Weight'></UserValue>" 
            + "      </UserData>" 
            + "  </Employee>"
            + "  <Employee id='2'>"
            + "      <Email>tp@xyz.com</Email>" 
            + "      <UserData id='id33' type='AttributesInContext'>"
            + "         <UserValue value='6in' title='Heigh'></UserValue>"
            + "         <UserValue value='' title='Weight'></UserValue>" 
            + "      </UserData>" 
            + "  </Employee>"
            + "  <Employee id='3'>"
            + "      <Email>tp@xyz.com</Email>" 
            + "      <UserData id='id34' type='AttributesInContext'>"
            + "         <UserValue value='4in' title='Heigh'></UserValue>"
            + "         <UserValue value='' title='Weight'></UserValue>" 
            + "      </UserData>" 
            + "  </Employee>"
            + "</Company>";

    public static void main(String[] args) throws Exception {

        try (InputStream in = new ByteArrayInputStream(TEST_XML.getBytes(Charset.defaultCharset()));
                ByteArrayOutputStream out = new ByteArrayOutputStream(4096)) {
            convert(in, out);
            System.out.print(out.toString());
        }

    }