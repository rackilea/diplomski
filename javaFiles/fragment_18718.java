public void myMainFunction() {
    ArrayList<Animal> animals = new ArrayList<Animal>();
    animals.add(AnimalFactory.createAnimal(Bird.class,birdXML));
    animals.add(AnimalFactory.createAnimal(Dog.class,dogXML));
}

public abstract class Animal {
    /**
     * Every animal subclass must be able to be created from XML when required
     * (E.g. if there is a tag <bird></bird>, bird would call its 'createFromXML' method
     */
    public abstract Animal createFromXML(String XML);
}

public class Bird extends Animal {
    @Override
    public Bird createFromXML(String XML) {
        // Implementation of how a bird is created with XML
    }
}

public class Dog extends Animal {
    @Override
    public Dog createFromXML(String XML) {
        // Implementation of how a dog is created with XML
    }
}

public class AnimalFactory{
    public static <T extends Animal> Animal createAnimal(Class<T> animalClass, String xml) {
          // Here check class and create instance appropriately and call createFromXml
          // and return the cat or dog
    }
}