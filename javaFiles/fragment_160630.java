public abstract class Animal {
    int numLegs;
    float speed; // in meters per second
    int weight;

    abstract void walk();

    abstract void eat(Object food);
}

public class Cat extends Animal {
    public Cat() {
        numLegs = 4; // cats generally have 4 legs
        weight = 10; // 10 pounds
        speed = 13; // cat can run 13 meters per second
    }

    public void walk() {
        // TODO: implement walking functionality for cat
    }

    public void eat(Object food) {
        // TODO: implement check to make sure food isn't poisonous
        // TODO: make cat eat food
    }
}

// Similarly for other animals

public class MyProgram {
    public void myWorld() {
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Cat());
        animals.add(new Spider());

        for (Animal a : animals) {
           a.move();
        }
    }
}