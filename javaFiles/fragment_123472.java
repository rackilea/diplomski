interface Groom<T extends Animal> {
  void groom(T t);
}

public class CatGroomer implements Groom<Cat> {
  void groom(Cat animal) {

  }
}