import java.util.*;

class Individual {
    public String name;
    public Individual(String name) {
        this.name = name;
    }
    public Individual () {
        this.name = new String();
    }
}
class Pet extends Individual {
  public Pet(String name) { super(name); }
  public Pet() { super(); }
} ///:~

class Rodent extends Pet {
  public Rodent(String name) { super(name); }
  public Rodent() { super(); }
} ///:~

class Cat extends Pet {
  public Cat(String name) { super(name); }
  public Cat() { super(); }
} ///:~

class Dog extends Pet {
      public Dog(String name) { super(name); }
      public Dog() { super(); }
    } ///:~

class Hamster extends Rodent {
  public Hamster(String name) { super(name); }
  public Hamster() { super(); }
} ///:~



public class PetMap {

  public static void main(String[] args) {

    Map<String,Pet> petMap = new HashMap<String,Pet>();

    petMap.put("My Hamster", new Hamster("Bosco"));

    // the two lines now work
    petMap.put("My Cat", new Cat("Molly"));

    petMap.put("My Dog", new Dog("Ginger"));

    System.out.println(petMap);

    Pet dog = petMap.get("My Dog");

    System.out.println(dog);

    System.out.println(petMap.containsKey("My Dog"));

    System.out.println(petMap.containsValue(dog));

  }

}