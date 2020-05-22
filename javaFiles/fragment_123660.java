public class Dog {
  protected String whatISay = "Woof!";
  public void speak(){
    System.out.println(whatISay);
  }
}


public class Poodle extends Dog {
  public Poodle(){
    whatISay = "Yap!";
  }
}


public class Main {
  public static void main(String[] args){
    Poodle fluffy = new Poodle();
    fluffy.speak();
    Dog dog = new Dog();
    dog.speak();
  }
}