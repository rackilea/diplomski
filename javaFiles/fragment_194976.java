class Animal {}
class Fox : Animal {}
class Fish : Animal {}

Animal a = new Fox(); // ok!
Animal b = new Fish(); // ok!
Fox f = b; // obviously no!