abstract class Animal {
    public Animal(int venerableAge){
       //carry out sense checks here. i.e.:
       if (venerableAge < 0) { /* doSomething */ }
    }
}

class Dog extends Animal {
   private static int venerableAge;

   public Dog(int age) {
      super(age)
      venerableAge = age;
   }
}