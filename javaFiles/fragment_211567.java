abstract class Animal {
   abstract int getVenerableAge();
}

class Dog extends Animal {
   private static int venerableAge = 10;

   public int getVenerableAge() {
      return venerableAge;
   }
}