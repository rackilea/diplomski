class Animal {

}
class Cat extends Animal {

}

interface AnimalHandler {
    void handleAnimal(Animal animal);
}

class CatHandler implements AnimalHandler {

    @Override
    public void handleAnimal(Animal animal) {
        Cat cat = (Cat)animal;
        // do something with a cat
    }

}

class AnimalServiceImpl implements AnimalHandler {
    Map<Class,AnimalHandler> animalHandlers = new HashMap<Class, AnimalHandler>();

    AnimalServiceImpl() { 
        animalHandlers.put(Cat.class, new CatHandler());
    }
    public void handleAnimal(Animal animal) {
        animalHandlers.get(animal.getClass()).handleAnimal(animal);
    }
}