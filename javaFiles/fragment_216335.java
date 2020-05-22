public <T extends Animal> Animal castToAnimal(T childAnimal) {
    Animal animal = null;
    if (childAnimal != null) {
        animal = Animal.class.cast(childAnimal);
        // Or use
        // animal = (Animal) childAnimal;
    }
    return animal;
}