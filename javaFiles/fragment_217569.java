class AnimalFactory {
    public static Animal createAdapter(Dog dog) {
        return new DogAdapter(dog);
    }

    public static Animal createAdapter(Cat cat) {
        return new CatAdapter(cat);
    }
}