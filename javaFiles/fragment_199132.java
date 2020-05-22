public abstract class Animal {
    public abstract void move();
}

public class Cat extends Animal {
    @Override public void move() {
        moveWithLegs();
    }

    public void moveWithLegs() {
        // Implementation
    }
}

public class Fish extends Animal {
    @Override public void move() {
        moveBySwimming();
    }

    public void moveBySwimming() {
        // Implementation
    }
}

Animal animal = new Cat();
animal.move(); // Okay
animal.moveWithLegs(); // Not okay
((Cat) animal).moveWithLegs(); // Okay
((Fish) animal).moveWithLegs(); // ClassCastException exception