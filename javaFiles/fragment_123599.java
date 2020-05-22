Dog dog = new Dog();
Animal cat = new Cat();

dog.testInstanceMethod(); // Not allowed, because Cat should not be able to access protected members of Dog
cat.testInstanceMethod(); // Not allowed, because compiler doesn't know that runtime type of cat is Cat

((Cat) cat).testInstanceMethod(); // Allowed