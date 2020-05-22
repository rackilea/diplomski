private interface AnimalFactory {
    Animal create();
}
private static final Map<String,AnimalFactory> factoryMap =
    Collections.unmodifiableMap(new HashMap<String,AnimalFactory>() {{
        put("Meow", new AnimalFactory() { public Animal create() { return new Cat(); }});
        put("Woof", new AnimalFactory() { public Animal create() { return new Dog(); }});
    }});

public Animal createAnimal(String action) {
    AnimalFactory factory = factoryMap.get(action);
    if (factory == null) {
        throw new EhException();
    }
    return factory.create();
}