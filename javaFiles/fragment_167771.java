abstract class Animal {
    void speak();
}

class Pig extends Animal {
    public void speak() {
        System.out.println("Oink");
    }
}

class Dog extends Animal {
    public void speak() {
        System.out.println("Woof");
    }
}

class Duck extends Animal {
    public void speak() {
        System.out.println("Qwack");
    }
}

List<Animal> animals = Arrays.<Animal>asList(new Dog(), new Pig(), new Duck);
for (Animal animal : animals)
    animal.speak();