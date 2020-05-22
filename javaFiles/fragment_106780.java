List<Dog> dogs = new ArrayList<>(); // safe collection
dogs.add(new Dog());

// dogs.add(new Cat()); // not allowed, dogs is safe

List raw = dogs; // raw handle to safe collection
raw.add(new Cat()); // works! heap pollution

// compiles, but throws at run-time,
// since it is actually a cat, not a dog
Dog dog = dogs.get(1);