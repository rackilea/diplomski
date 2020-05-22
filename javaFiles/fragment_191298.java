class PizzaTruck extends Truck implements Kitchen {
   Kitchen kitchen;

   public void cook(Food foodItem) {
      kitchen.cook(foodItem);
   }
}