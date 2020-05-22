public static void main(String[] args) {
    // TODO Auto-generated method stub
    List<Item> InvetoryItems;

    Inventory inv = new Inventory();
    inv.createItemObj(101, "camera", "Used camera that I bought off of a homeless guy.", 500);
    InvetoryItems = inv.getAllInventoryItems();

    for(Item item : InvetoryItems){
           System.out.println(item.getItemName());
    }

    System.out.println("Done");
}