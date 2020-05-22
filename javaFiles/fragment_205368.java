import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

    public class yourClass{
    public static void main(String[] args) {

        File xml = new File("yourFile.xml");
        try {
            Document doc = (Document) new SAXBuilder().build(xml);
            Element rootNode = doc.getRootElement();
            List list = rootNode.getChildren("staff");
            XMLOutputter xmlOut = new XMLOutputter();

            for (int i = 0; i < list.size(); i++) {

                Element node = (Element) list.get(i);
                if (node.getChildText("firstname").equals("sanjay"))
                    node.getChild("salary").getChild("basic").setText("250000");
                xmlOut.setFormat(Format.getPrettyFormat());
                xmlOut.output(doc, new FileWriter("yourFile.xml"));
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
    }

}