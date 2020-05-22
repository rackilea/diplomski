public class Animal {
   public void someAction() {
      System.out.println("from Animal class");
   }
}

public class Dog extends Animal {
   public void someAction() {
      super.someAction();
      System.out.println("from Dog class");
   }
}

public class Main {

  public static void main(String[] args){
      Animal dog = new Dog();
      dog.someAction();
  }
}