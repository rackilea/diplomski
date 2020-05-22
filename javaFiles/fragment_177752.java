HashMap<String, ArrayList<Item>> items = new HashMap<String, ArrayList<Item>>();

public synchronized void addToList(String mapKey, Item myItem) {
    List<Item> itemsList = items.get(mapKey);

    // if list does not exist create it
    if(itemsList == null) {
         itemsList = new ArrayList<Item>();
         itemsList.add(myItem);
         items.put(mapKey, itemsList);
    } else {
        // add if item is not already in list
        if(!itemsList.contains(myItem)) itemsList.add(myItem);
    }
}