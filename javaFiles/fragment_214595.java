Dog dog = new Dog();
    Animal[] animals = new Animal[5];
    animals [0] = new Dog();
    animals [1] = new Cat();
    animals [2] = new Wolf();
    animals [3] = new Hippo();
    animals [4] = new Lion();

    for (int i = 0; i < animals.length; i++) {
        animals[i].eat();
        animals[i].makeNoise();
        animals[i].testPolymorphism();

        if (dog.equals(animals[i])) {
           System.out.println("DogArray matches Dog i" + i);
        }else{
           System.out.println("DogArray doesn't match any animal");
        } 
     }