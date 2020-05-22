public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        List<Animal> dogKennel = List.of(dog1, dog2);
        List<Animal> catKennel = List.of(cat1, cat2);

        for(Animal x : catKennel) {
            System.out.println(x.isGraduated());
        }
    }
}