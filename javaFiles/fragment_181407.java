class ItemXmlAdapter extends XmlAdapter<Object, Item> {

    @Override
    public Item unmarshal(Object v) {
        Element element = (Element) v;

        Map<String, String> properties = new HashMap<>();
        NamedNodeMap attributes = element.getAttributes();
        for (int i = attributes.getLength() - 1; i >= 0; i--) {
            Node node = attributes.item(i);
            properties.put(node.getNodeName(), node.getNodeValue());
        }

        Item item = new Item();
        item.setProperties(properties);

        return item;
    }

    @Override
    public Object marshal(Item v) throws Exception {
        return null; // Implement if needed
    }
}