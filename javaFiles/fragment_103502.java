Animal a1 = new Animal(); // works
Animal a2 = new Dog(); // works, Dog a subtype of animal
Dog d1 = new Animal(); // does not work, Animal not a subtype of Dog
a1 = a2; // works
d1 = a1; // doesn't work

// If Dog has a function "bark" and Animal has a function "breathe"
a1.breathe(); // works
d1.breathe(); // works
d1.bark(); // works
a1.bark(); // does not compile, Animal not always a Dog