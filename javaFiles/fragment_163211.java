// Note - inheritance isn't used here since it breaks due to method overriding issues.
  public static class BirdZoo<T extends Animal & Bird> {
    private List<T> animals = new ArrayList<>();
    public <X extends Animal & Bird> void addAnimal(X animal) {
      this.animals.add((T)animal); // Unchecked cast warning
    }
    public List<T> getAnimals() {
      return Collections.unmodifiableList(animals);
    }
  }

  BirdZoo<?> wildBirdZoo = new BirdZoo<>();
  wildBirdZoo.addAnimal(new Ostrich()); // ok
  wildBirdZoo.addAnimal(new Sparrow()); // ok
  wildBirdZoo.addAnimal(new Meerkat()); // error - incompatible types
  wildBirdZoo.addAnimal(new Buffalo()); // error - incompatible types