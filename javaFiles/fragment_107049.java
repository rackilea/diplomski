public void insertNewProject(Project entity) {
    String filePath = "location.xml";
    File xmlFile = new File(filePath);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder;
    try {
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc;

        doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        Node n = doc.getElementsByTagName("n").item(0);

        Element a = doc.createElement("a");
        n.insertBefore(a, n.getFirstChild());

        Element b = doc.createElement("b");
        b.appendChild(doc.createTextNode(entity.getLocation()));
        a.appendChild(b);

        Element c = doc.createElement("c");
        c.appendChild(doc.createTextNode(entity.getName()));
        a.appendChild(c);

        doc.getDocumentElement().normalize();

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(new File("location.xml"));
        transformer.transform(domSource, streamResult);

    } catch (ParserConfigurationException pce) {
        return;
    } catch (IOException e) {
        e.printStackTrace();
    } catch (SAXException e) {
        e.printStackTrace();
    } catch (TransformerException tfe) {
        return;
    }
}