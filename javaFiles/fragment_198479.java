interface Carnivore {
  void eat(Meat food);
}

interface Herbivore {
  void eat(Plant food);
}

interface Omnivore extends Carnivore, Herbivore {
  // overrides both above eat methods,
  // since Meat and Plant are subtypes of Food
  void eat(Food food);
}