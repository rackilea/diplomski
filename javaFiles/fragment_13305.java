List<Item> values;
Item currentItem = buffer.get(i);
itemNames[i] = currentItem.getName();
List<Attribute> currentAttributes = currentItem.getAttributes();
String favorited = "";
for (Attribute anAttribute : currentAttributes) {
    if (anAttribute.getName().equals("Favorited")) {
        favorited = anAttribute.getValue();
    }
}