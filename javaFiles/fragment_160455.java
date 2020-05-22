public static Document fetchRequiredData(String src) {
    Document doc = null;

    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder parser;

    try {
        parser = dbFactory.newDocumentBuilder();
        doc= parser.parse(src);
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } catch (SAXException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return doc;
}

public static List<Item>  parseItemInfo(Document doc){

    List<Item> items = new ArrayList<Item>();
    NodeList itemNodeList = doc.getElementsByTagName("Item");       

    for (int i = 0; i < itemNodeList.getLength(); i++) {

        Node titleNode = doc.getElementsByTagName("Title").item(i);
        Node priceNode = doc.getElementsByTagName("LowestNewPrice").item(i).getFirstChild();

        if (titleNode.getNodeType() == Node.ELEMENT_NODE || priceNode.getNodeType() == Node.ELEMENT_NODE ) {
            Item item = new Item();
            item.setDesc(titleNode.getTextContent());
            item.setPrice(priceNode.getTextContent());
            items.add(item);
        }
    }
    return items;
}