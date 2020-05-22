interface Species {

}

class Animal implements Species {

}

class Cat extends Animal {

}

class Dog extends Animal {

}

class Plant implements Species {

}

class Tree extends Plant {

}

public void test() {
    System.out.println("Hello");
    List<Animal> animals = new ArrayList<>();
    animals.add(new Cat());
    animals.add(new Dog());
    // Not allowed.
    //animals.add(new Tree());

    // The old way.
    List beasts = new ArrayList();
    beasts.add(new Cat());
    beasts.add(new Dog());
    // Allowed - only caught at run time and difficult to find.
    beasts.add(new Tree());

    // The interface way.
    List<Species> living = new ArrayList();
    living.add(new Cat());
    living.add(new Dog());
    // Allowed.
    living.add(new Tree());

}