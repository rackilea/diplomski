//ON THE CONSTRUCTOR, INITIALIZE GROUP AND ITEMS
org.openscada.opc.lib.da.Group group = server.addGroup("GroupName");
Item items[] = new Item[numberOfItems]= group.addItem("itemID"); 
//YOU WILL NEED TO HAVE ACCESS TO items[] LATER, MAKE IT PUBLIC.

for (int index = 0; index < numberOfItems; index++) {
    items[index] = group.addItem("item"+index);
}