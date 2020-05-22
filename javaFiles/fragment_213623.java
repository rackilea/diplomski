import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlGenerator {

    Document document = null;
    Element root = null;

    private void generateXml() {

        try {

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

            document = documentBuilderFactory.newDocumentBuilder().newDocument();

            root = document.createElement("FlyBoy");
            document.appendChild(root);

            Element learJet = document.createElement("learJet");
            learJet.setTextContent("CL-215");
            root.appendChild(learJet);

            Element rank = document.createElement("rank");
            rank.setTextContent("2");
            root.appendChild(rank);

            Element flyBoy1 = renderFlyBoy(root, "Mark II", "1");
            Element flyBoy2 = renderFlyBoy(flyBoy1, "Mark II4455", "2");
            Element flyBoy3 = renderFlyBoy(flyBoy2, "Mark II56666", "3");

            DOMSource domSource = new DOMSource(document);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            StreamResult result = new StreamResult(new File("my.xml"));
            transformer.transform(domSource, result);

        } catch (ParserConfigurationException | TransformerFactoryConfigurationError | TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Render flyboy
     * 
     */
    private Element renderFlyBoy(Element parent, String viper, String rank) {

        Element flyBoyEl = document.createElement("FlyBoy");
        parent.appendChild(flyBoyEl);

        Element viperEl = document.createElement("viper");
        viperEl.setTextContent(viper);
        flyBoyEl.appendChild(viperEl);

        Element rankEl = document.createElement("rank");
        rankEl.setTextContent(rank);
        flyBoyEl.appendChild(rankEl);

        return flyBoyEl;

    }

    // Test
    public static void main(String[] args) {
        XmlGenerator ob = new XmlGenerator();
        try {
            ob.generateXml();
            System.out.println("done...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}