import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.beanutils.BeanUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class DOMParsarDemo2 {
    protected DocumentBuilder docBuilder;
    protected Element root;

    private static List<SubMainLevel> subMainLevels = new ArrayList<SubMainLevel>();

    public DOMParsarDemo2() throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        docBuilder = dbf.newDocumentBuilder();
    }

    public void parse(String file) throws Exception {
        Document doc = docBuilder.parse(new FileInputStream(file));
        root = doc.getDocumentElement();
        System.out.println("root element is :" + root.getNodeName());
    }

    public void printAllElements() throws Exception {
        printElement(root);
    }

    public void printElement(Node node) {
        if (node.getNodeType() != Node.TEXT_NODE) {
            Node child = node.getFirstChild();
            while (child != null) {
                if ("SubMainLevel".equals(child.getNodeName())) {
                    NamedNodeMap namedNodeMap = child.getAttributes();

                    Map<String, String> attrMap = new HashMap<String, String>();
                    for (int i = 0; i < namedNodeMap.getLength(); i++) {
                        Node n = namedNodeMap.item(i);
                        attrMap.put(n.getNodeName(), n.getNodeValue());
                    }

                    SubMainLevel subMainLevel = new SubMainLevel();
                    try {
                        BeanUtils.populate(subMainLevel, attrMap);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    subMainLevels.add(subMainLevel);
                }
                printElement(child);
                child = child.getNextSibling();
            }
        }
    }

    public static void main(String args[]) throws Exception {
        DOMParsarDemo2 demo = new DOMParsarDemo2();
        demo.parse("resources/abc1.xml");
        demo.printAllElements();

        for (SubMainLevel subMainLevel : subMainLevels) {
            System.out.println(subMainLevel);
        }
    }
}