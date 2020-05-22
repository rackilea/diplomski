package forum12569441;

import java.io.*;
import javax.xml.stream.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        // WRITE THE XML
        XMLOutputFactory xof = XMLOutputFactory.newFactory();

        StringWriter sw = new StringWriter();
        XMLStreamWriter xsw = xof.createXMLStreamWriter(sw);
        xsw.writeStartDocument();
        xsw.writeStartElement("foo");
        xsw.writeCharacters("<>\"&'");
        xsw.writeEndDocument();

        String xml = sw.toString();
        System.out.println(xml);

        // READ THE XML
        XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(xml));
        xsr.nextTag(); // Advance to "foo" element
        System.out.println(xsr.getElementText());
    }

}