abstract class Animal {
    private final String name;

    Animal(String name) {
        this.name = name;
    }

    final String getName() {
        return this.name;
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
}