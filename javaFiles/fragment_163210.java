public static abstract class Zoo{
    private List<Animal> animals = new ArrayList<>();

    protected void addAnimalHelper(Animal animal) {
      this.animals.add(animal);
    }
  }

  public static class BirdZoo extends Zoo {
    public <T extends Animal & Bird> void addAnimal(T animal) {
      addAnimalHelper(animal);
    }
  }

  BirdZoo birdZoo = new BirdZoo();
  birdZoo.addAnimal(new Ostrich()); // ok
  birdZoo.addAnimal(new Sparrow()); // ok
  birdZoo.addAnimal(new Meerkat()); // Meekrat doesn't conform to Bird
  birdZoo.addAnimal(new Buffalo()); // Buffalo doesn't conform to Bird