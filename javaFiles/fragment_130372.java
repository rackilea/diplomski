abstract class Bird {
    void eat() {
        // Because all birds get hungry
    }
}

abstract class FlyingBird extends Bird {
    void fly() {
        // Do the flight!
    }
}

abstract class GroundedBird extends Bird {
    void waddle() {
        // They gotta get around somehow.
    }
}

class Penguin extends GroundedBird;
class Goose extends FlyingBird;