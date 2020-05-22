URL url = new URL(getString(R.string.XmlUrlAddress));
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
Document doc = db.parse(new InputSource(url.openStream()));
doc.getDocumentElement().normalize();

NodeList nodeList = doc.getElementsByTagName("Placemark");
String[] files = new String[nodeList.getLength()];

for (int i=0; i < nodeList.getLength(); i++) {
    files[i] = "file" + i + ".xml";
    //Create and open files[i] file.
    //Write opening tag.  "<Placemark>"

    Node node = nodeList.item(i);
    Element element = (Element)node;

    NodeList nameList = element.getElementsByTagName("name");
    Element name = (Element)nameList.item(0);
    nameList = name.getChildNodes();
    String name = nameList.item(0).getNodeValue();
    //Write name to file.  "<name>" + name + "</name>"

    NodeList pointList = element.getElementsByTagName("Point");
    String[] points = new String[pointList.getLength()];

    //Write opening Points tag. "<Points>"
    for (int j=0; j < pointList.getLength(); j++) {
        Node cNode = pointList.item(j);
        Element cElement = (Element)cNode;

        NodeList coordinateList = element.getElementsByTagName("coordinates");
        Element coordinateElement = (Element)coordinateList.item(0);
        coordinateList = coordinateElement.getChildNodes();
        points[j] = coordinateList.item(0).getNodeValue();

        //Write points[j] to file. "<coordinates>" + points[j] + "</coordinates>"
    }
    //Write end Points tag.  "</Points>"
    //Write end document tag.  "</Placemark>"
    //Close file
}