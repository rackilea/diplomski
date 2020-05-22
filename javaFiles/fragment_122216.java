/**
 * Created by RGOVIND on 11/10/2016.
 */
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
public class XMLRootAdd {
    public static void main(String[] args) throws Exception
    {
        String xml = "<Order></Order>";
        InputStream iStream =  new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document orderDoc = builder.parse(iStream);
        Node oldOrderNode = orderDoc.getDocumentElement();
        Document newDocument = builder.newDocument();
        Element newRoot = newDocument.createElement("NewDoc");
        newDocument.appendChild(newRoot);
        newRoot.appendChild(newDocument.importNode(oldOrderNode, true));

        /*Print and test*/
        DOMSource domSource = new DOMSource(newDocument);
        Writer writer = new OutputStreamWriter(System.out);
        StreamResult result = new StreamResult(writer);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.transform(domSource, result);
        writer.flush();

    }
}