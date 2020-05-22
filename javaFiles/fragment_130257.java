import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class StackOverflow23556822 {

    public static void main(String[] args) throws ParserConfigurationException,
            TransformerException {
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("JAVA");
        doc.appendChild(rootElement);

        Iterator<?> it = System.getProperties().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
            String keyString = (String) entry.getKey();
            String val = (String) entry.getValue();
            List<String> sa = Arrays.asList(keyString.split("\\."));

            Iterator<?> ait = sa.iterator();

            Element destination = rootElement;
            Element tag = null;
            while (ait.hasNext()) {
                tag = doc.createElement((String) ait.next());
                destination.appendChild(tag);
                destination = tag;
            }
            destination.appendChild(doc.createTextNode(val));

        }

        Transformer transformer = null;
        TransformerFactory transformerFactory = TransformerFactory
                .newInstance();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("xml-test.xml"));

        transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(source, result);

        System.out.println("File saved!");
    }
}