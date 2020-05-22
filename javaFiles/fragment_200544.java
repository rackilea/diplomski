class User {
   private final Inventory inventory;
   User () {
       inventory = new Inventory(this);
   }
}