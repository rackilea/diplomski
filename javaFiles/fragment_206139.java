public static void main(String[] args) {
    TypedMap map = new TypedMap();
    List<Cat> cats = new ArrayList<>();
    List<Dog> dogs = new ArrayList<>();
    adder.put(Cat.class, cats);
    adder.put(Dog.class, dogs);

    adder.put(Cat.class, dogs); // compilation error
}