public Room(String description, Item item) 
{
    // ...
    addItem(item);
    this.itemDescription = "This room contains: " + item.getLongDescription() ;
    // ...
}