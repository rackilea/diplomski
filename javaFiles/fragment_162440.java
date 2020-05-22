ArrayList<Item> itemList = new ArrayList<Item>();

// Fill the list
itemList.add(new Item("Banana"));
itemList.add(new Item("Toaster"));
itemList.add(new Item("Screw Driver"));

Item item = new Item("Hand Grenade");
itemList.add(item);

int index = itemList.indexOf(item);
if( index != -1 ){
  System.out.println("The item is in index " + index);

  // Remove the item and store it in a variable
  Item removedItem = itemList.remove(index);
  System.out.println("We removed " + removedItem.getType() + " from the list.");
}