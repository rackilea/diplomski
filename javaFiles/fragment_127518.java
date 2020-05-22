class FruitStore {
   private Map<Class<? extends Fruit>, List<Fruit>> fruitMap = 
         new HashMap<Class<? extends Fruit>, List<Fruit>>();

   public void addFruit(Fruit fruit) {
      Class<? extends Fruit> fruitClass = fruit.getClass();
      List<Fruit> fruitList = fruitMap.get(fruitClass);
      if (fruitList == null) {
         fruitList = new ArrayList<Fruit>();
         fruitMap.put(fruitClass, fruitList);
      }
      fruitList.add(fruit);
   }

   public void displayStore() {
      for (List<Fruit> fruitList : fruitMap.values()) {
         System.out.println(fruitList);
      }
   }
}