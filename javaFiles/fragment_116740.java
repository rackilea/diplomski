public FruitFetcher { 
   public static Fruit fetch(FruitType type) {
     switch(type) {
       case APPLE:  return new Apple();
       case BANANA: return new Banana();
     }
   }
   return null;
}