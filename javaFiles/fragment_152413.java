import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

/**
 * Demo xml processing
 */
public class Demo {

    private static final Logger log = Logger.getLogger(Demo.class.getName());

    private static final int CHUNK = 1048576;  //1MB chunk of file

    public static void main(String[] args) {

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream(CHUNK);

            Writer writer = new OutputStreamWriter(out, "UTF-8");

            /* here put soapMessage.writeTo(out);
               I will just process this hard-coded xml */
            writer.append("<greeting>Hello!</greeting>");
            writer.flush();

            ByteArrayInputStream is
                    = new ByteArrayInputStream(out.toByteArray());

            XMLReader reader = XMLReaderFactory.createXMLReader();

            //define your handler which extends default handler somewhere else
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);

            /* reader will be closed with input stream */
            reader.parse(new InputSource(new InputStreamReader(is, "UTF-8")));
            //Hello in the console
        } catch (UnsupportedEncodingException ex) {
            log.severe("Unsupported encoding");
        } catch (IOException | SAXException ex) {
            log.severe("Parsing error!");
        } finally {
            /*everything is ok with byte array streams!
              closing them has no effect! */
        }

    }
}

class MyHandler extends DefaultHandler {

    @Override
    public void characters(char ch[], int start, int length)
            throws SAXException {
        System.out.print(String.copyValueOf(ch, start, length));
    }
}