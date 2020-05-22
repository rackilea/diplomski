public abstract class AnimalDescriptor<T> { // or <T extends Animal>

    public abstract List<String> getProperties();

    public abstract T newAnimal();

}

public class DogDescriptor extends AnimalDescriptor<Dog> {

    public static final DogDescriptor INSTANCE = new DogDescriptor();

    public List<String> getProperties() { ... }

    public Dog newAnimal() { return new Dog(); }

}

void doStuff(AnimalDescriptor<?> desc) {
    desc.getProperties();
}

doStuff(DogDescriptor.INSTANCE);