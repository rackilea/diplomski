public class InventoryItem {
     private String name = "";
     private int units;
     private double price;

     public InventoryItem(){
     }

     public InventoryItem (String name, int units, double price){
         this.name = name;
         this.units = units;
         this.price = price;
     }
     // ... etc
}