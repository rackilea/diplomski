import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class FooMain {

    public static Document slurpXML(String s) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {

            }

            @Override
            public void error(SAXParseException exception) throws SAXException {

            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {

            }
        });
        Document rv = builder.parse(new ByteArrayInputStream(s.getBytes("UTF-8")));
        return rv;
    }

    public static void main(String args[]) throws Exception {
        try {
            slurpXML("foo");
        } catch (Throwable e) {} // try to silence it - in vain
    }
}