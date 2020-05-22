class Dog extends Animal {
    private final String name;

    Dog(String name) {
        this.name = name;
    }

    @Override
    String getName() {
        return name;
    }
}

class Cat extends Animal {
    private final String name;

    Cat(String name) {
        this.name = name;
    }

    @Override
    String getName() {
        return name;
    }
}