abstract class Animal<A extends Animal<A>> {
  abstract A copyAnimal(A animal);
}

class Duck<D extends Duck<D>> extends Animal<D> {
  void quack() {}

  D copyAnimal(D duck) {
    duck.quack();
    return duck;
  }
}

class Mallard extends Duck<Mallard> {
  Mallard copyAnimal(Mallard duck) {
    duck.quack();
    return duck;
  }
}