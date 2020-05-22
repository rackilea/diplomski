private void parsexml(String xmlresult){

    ListView myList=(ListView)findViewById(android.R.id.list);

    menuItems = new ArrayList<HashMap<String, String>>();

    XmlParser parser = new XmlParser();
    Document doc = parser.getDomElement(xmlresult); // getting DOM element
    NodeList nl = doc.getElementsByTagName(KEY_ITEM);

    // looping through all item nodes <item>
    for (int i = 0; i < nl.getLength(); i++) {
        // creating new HashMap
        HashMap<String, String> map = new HashMap<String, String>();
        Element e = (Element) nl.item(i);
        // adding each child node to HashMap key => value
        map.put(KEY_ID,  parser.getValue(e, KEY_ID));
        map.put(KEY_NAME, parser.getValue(e, KEY_NAME));
        map.put(KEY_COST, "Rs." + parser.getValue(e, KEY_COST));
        map.put(KEY_DESC, parser.getValue(e, KEY_DESC));
        map.put(KEY_DESC, parser.getValue(e, KEY_categroy));
        map.put(KEY_DESC, parser.getValue(e, KEY_order));
        // adding HashList to ArrayList
        menuItems.add(map);
    }
    // Adding menuItems to ListView
    ListAdapter adapter = new SimpleAdapter(this, menuItems,
            R.layout.list_item,
            new String[] { KEY_NAME, KEY_DESC, KEY_COST,KEY_categroy,KEY_order }, new int[] {
            R.id.name, R.id.desciption, R.id.cost,R.id.categroy,R.id.order });

    myList.setListAdapter(adapter);
    ((BaseAdapter)adapter).notifyDataSetChanged();

}