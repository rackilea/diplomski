import java.io.ByteArrayOutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Test1 {

    public static Document userdom;

    public static void main(String[] args) {
        try {
            userdom = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = userdom.createElement("users");
            Node adoptNode = userdom.adoptNode(root);
            userdom.appendChild(adoptNode);

            reg();
        } catch (ParserConfigurationException | DOMException exp) {
            exp.printStackTrace();
        }
    }

    public static void reg() {
        Element e = userdom.createElement("user");

        e.setAttribute("id", "blah");
        e.setAttribute("username", "kermit");
        e.setAttribute("password", "bunnies in the air");
        e.setAttribute("login", "kermmi");

        userdom.getFirstChild().appendChild(e);
        System.out.println(e);
        System.out.println(userdom.getFirstChild() + "|" + userdom.getFirstChild().getFirstChild());
        saveUserDom();
    }

    public static void saveUserDom() {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();
            System.out.println(userdom.getFirstChild() + "|" + userdom.getFirstChild().getFirstChild());
            DOMSource ds = new DOMSource(userdom);

            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                StreamResult sr = new StreamResult(baos);
                trans.transform(ds, sr);

                System.out.println(new String(baos.toByteArray()));
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}