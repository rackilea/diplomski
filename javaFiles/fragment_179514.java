import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
// other imports...

public static void printPomDependencies() throws IOException, SAXException, ParserConfigurationException {
    // pom relative to your project directory
    final File pomFile = new File("./pom.xml");

    DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document doc = dBuilder.parse(pomFile);
    doc.getDocumentElement().normalize();
    final NodeList dependencyNodes = doc.getElementsByTagName("dependency");

    for (int i = 0; i < dependencyNodes.getLength(); i++) {
        final Node n = dependencyNodes.item(i);

        final NodeList list = n.getChildNodes();

        System.out.println("----------------------------------");
        for (int j = 0; j < list.getLength(); j++) {
            final Node n2 = list.item(j);
            // do not print empty text nodes or others...
            if (n2.getNodeType() != Node.ELEMENT_NODE) continue;


            System.out.println(n2.getNodeName() + ":" + n2.getTextContent());

        }
    }
}