import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitManager {
   public static void main(String[] args) {
      FruitStore fruitStore = new FruitStore();
      for (int i = 0; i < 20; i++) {
         if (i % 3 == 0) {
            fruitStore.addFruit(new Banana());
         } else {
            fruitStore.addFruit(new Apple());
         }
      }

      fruitStore.displayStore();
   }
}

abstract class Fruit {
   public abstract String getName();

   @Override
   public String toString() {
      return getName();
   }
}

class Apple extends Fruit {

   private static final String NAME = "Apple";

   @Override
   public String getName() {
      return NAME;
   }

}


class Banana extends Fruit {

   private static final String NAME = "Banana";

   @Override
   public String getName() {
      return NAME;
   }

}

class FruitStore {
   private Map<Class<? extends Fruit>, List<Fruit>> fruitMap = 
         new HashMap<Class<? extends Fruit>, List<Fruit>>();

   public void addFruit(Fruit fruit) {
      Class<? extends Fruit> fruitClass = fruit.getClass();
      List<Fruit> fruitList = fruitMap.get(fruitClass);
      if (fruitList == null) {
         fruitList = new ArrayList<Fruit>();
      }
      fruitList.add(fruit);
      fruitMap.put(fruitClass, fruitList);
   }

   public void displayStore() {
      for (List<Fruit> fruitList : fruitMap.values()) {
         System.out.println(fruitList);
      }
   }
}