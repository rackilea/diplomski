NodeList nl = doc.getElementsByTagName(KEY_ITEM);

// looping through all item nodes <item>     
for (int i = 0; i < nl.getLength(); i++) {
    Element e = (Element)nl.item(i); // >>> the missing line in the sample <<<
    String name = parser.getValue(e, KEY_NAME); // name child value
    String cost = parser.getValue(e, KEY_COST); // cost child value
    String description = parser.getValue(e, KEY_DESC); // description child value
}