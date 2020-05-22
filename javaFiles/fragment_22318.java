static class Lion implements Animal {}

static class Zebra implements Animal {}

final Zoo zoo = new Zoo();
zoo.addAnimal(new Lion());
zoo.addAnimal(new Zebra());
zoo.addAnimal(new Lion());

zoo.getAnimals(Lion.class); // returns two lion instances

zoo.getSpeciesOrdering(); // returns [Lion.class, Zebra.class]