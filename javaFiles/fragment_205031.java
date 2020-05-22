public enum Fruit {
   ...
   static public boolean isMember(String aName) {
       Fruit[] aFruits = Fruit.values();
       for (Fruit aFruit : aFruits)
           if (aFruit.fruitname.equals(aName))
               return true;
       return false;
   }
   ...
}