private interface AnimalFactory {
    Animal create();
}
private static final Map<String,AnimalFactory> factoryMap = {
    "Meow" : { -> new Cat() },
    "Woof" : { -> new Dog() },
};

public Animal createAnimal(String action) {
    AnimalFactory factory = factoryMap.get(action);
    if (factory == null) {
        throw EhException();
    }
    return factory.create();
}