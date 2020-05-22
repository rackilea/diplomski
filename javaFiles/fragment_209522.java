public class ReadXMLFile {

private static boolean _initialized = false;
private static Document _doc;

public static void init() {
    if(_initialized) {
        return;
    }

    try {
        File fXmlFile = new File("res/files/strings.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        _doc = dBuilder.parse(fXmlFile);
        _doc.getDocumentElement().normalize();

        _initialized = true;
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static String readXML(String name, int lang) {
    if(!_initialized) {
        init();
    }

    String res = "";

    try {
        NodeList nList = _doc.getElementsByTagName("lang");
        Node nNode = nList.item(lang);
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNode;
            res=eElement.getElementsByTagName(name).item(0).getTextContent();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return res;
}
}