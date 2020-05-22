import java.io.ByteArrayOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

public class DomLsTest {

    @Test
    public void testDomLs() throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        DOMImplementation di = db.getDOMImplementation();
        Document d = di.createDocument("", "foo", null);
        Element e = d.createElement("bar");
        d.getDocumentElement().appendChild(e);
        DOMImplementationLS ls = (DOMImplementationLS) di;
        LSOutput lso = ls.createLSOutput();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        lso.setByteStream(baos);
        LSSerializer lss = ls.createLSSerializer();
        lss.write(d, lso);
        System.out.println(baos.toString());
    }

}