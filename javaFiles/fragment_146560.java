public class PropertyValueConverter implements Converter<PropertyValue> {
    @Override
    public PropertyValue read(InputNode node) throws Exception {
        PropertyValue propertyValue = new PropertyValue();
        List<ItemData> propertyValueItems = new ArrayList<>();
        String propertyValueText = "";

        InputNode itemNode = node.getNext("item");
        while (itemNode != null) {
            String itemId = itemNode.getAttribute("id").getValue();
            ItemData itemData = new ItemData();
            itemData.setId(itemId);
            propertyValueItems.add(itemData);
            itemNode = node.getNext("id");
        }

        if (propertyValueItems.size() == 0) {
            propertyValueText = node.getValue();
        }

        propertyValue.setItems(propertyValueItems);
        propertyValue.setText(propertyValueText);

        return propertyValue;
    }

    @Override
    public void write(OutputNode node, PropertyValue value) throws Exception {

    }
}