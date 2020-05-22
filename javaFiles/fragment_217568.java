interface Animal {
    void speak();
    void eat();
}

class DogAdapter implements Animal {
    private Dog dog;

    public DogAdapter(Dog dog) {
        this.dog = dog;
    }

    public void speak() {
        dog.speak();
    }

    public void eat() {
        dog.eat(dog.findFood());
    }
}

class CatAdapter implements Animal {
    private Cat cat;

    public CatAdapter(Cat cat) {
        this.cat = cat;
    }

    public void speak() {
        cat.speak();
    }

    public void eat() {
        cat.eat(cat.findFood());
    }
}