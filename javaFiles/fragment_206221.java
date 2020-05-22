import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Main {

    private static final String xml = 
            "<root>\n" +
            "    <a>\n" +
            "        <b>some-value1</b>\n" +
            "        <c>some-value2</c>\n" +
            "    </a>\n" +
            "    <a>\n" +
            "        <b>some-value3</b>\n" +
            "        <c>some-value4</c>\n" +
            "    </a>\n" +
            "    <p>some-value-p</p>\n" +
            "</root>";

    public static void main(String[] args) {
        try {
            byte[] bytes = xml.getBytes(StandardCharsets.UTF_8);
            try (InputStream input = new ByteArrayInputStream(bytes)) {
                Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(input);
                Element root = document.getDocumentElement();
                flattXml("", root);
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void flattXml(String currentPath, Node currentNode) {
        if (currentNode.getNodeType() == Node.TEXT_NODE &&
                !currentNode.getNodeValue().trim().isEmpty()) {
            System.out.println(currentPath + "=" + currentNode.getNodeValue());
        } else {
            NodeList childNodes = currentNode.getChildNodes();
            int length = childNodes.getLength();
            String nextPath = currentPath.isEmpty()
                    ? currentNode.getNodeName()
                    : currentPath + "." + currentNode.getNodeName();
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                flattXml(nextPath, item);
            }
        }
    }

}