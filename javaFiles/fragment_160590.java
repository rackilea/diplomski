public class Warehouse {
    private List<InventoryItem> inventory = new ArrayList<InventoryItem>();

    public void addItem(InventoryItem i) 
        inventory.add(i);
    }

    public static void main(String [] args) {
        // create a Warehouse instance
        Warehouse warehouse = new Warehouse();
        // create an InventoryItem instance 
        InventoryItem i = new InventoryItem(sku, itemName, price, stock);
        // add the InventoryItem to the Warehouse
        warehouse.addItem(i);    
    }
}