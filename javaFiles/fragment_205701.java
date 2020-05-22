for (Menu cn : contacts) {

    // creating new HashMap - for every Menu
    HashMap<String, String> map = new HashMap<String, String>(); // this should be within the for loop.

    // Writing Contacts to log
    // adding each child node to HashMap key => value
    map.put(TAG_PID, cn.getID().toString());
    map.put(TAG_NAME, cn.getName().toString());

    // adding HashList to ArrayList
    productsList.add(map);
}