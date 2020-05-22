BirdZoo<?> wildBirdZoo = new BirdZoo<>();
wildBirdZoo.addAnimal(new Ostrich()); // ok
wildBirdZoo.addAnimal(new Sparrow()); // ok

BirdZoo<Ostrich> ostrichBirdZoo = new BirdZoo<>();
ostrichBirdZoo.addAnimal(new Ostrich()); // ok
ostrichBirdZoo.addAnimal(new Sparrow()); // ok and doesn't throw at runtime --> Sparrow to Ostrich cast succeeds.

System.out.println(wildBirdZoo.getAnimals());
System.out.println(ostrichBirdZoo.getAnimals()); // Contains a sparrow...?