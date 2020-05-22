import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;

public class Foobar {

    public static void main(String[] args) throws Exception {
        /* one way */
        FileOutputStream fileOutputStream = new FileOutputStream(new File("/tmp/foobar.txt"));
        String data = "<tag>  \n" +
                "   <abc=\"1\"/>  \n" +
                "   <cde=\"a\"/>  \n" +
                "   <xyz=\"3\"/>  \n" +
                "</tag>  ";

        fileOutputStream.write(data.getBytes());

        /* another way */
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element tag = doc.createElement("tag");
        Attr abc = doc.createAttribute("abc");
        Attr cde = doc.createAttribute("cde");
        Attr xyz = doc.createAttribute("xyz");
        abc.setValue("1");
        cde.setValue("2");
        xyz.setValue("3");
        CDATASection cdataSection = doc.createCDATASection(makeInvalidTag(abc) + makeInvalidTag(cde) + makeInvalidTag(xyz));
        tag.appendChild(cdataSection);
        doc.appendChild(tag);
        StreamResult streamResult = new StreamResult(new File("/tmp/foobar2.txt"));
        DOMSource domSource = new DOMSource(doc);
        TransformerFactory.newInstance().newTransformer().transform(domSource, streamResult);
    }

    private static String makeInvalidTag(Attr attr) {
        return "\u003C" + attr.toString() + "/\u003E";
    }
}