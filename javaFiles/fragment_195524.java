Animal animal; // define a variable for whatever animal we will create

if (condition) {
    Dog dog = new Dog(); // create a new Dog using the Dog constructor
    dog.setD(..);
    dog.setE(..);  
    animal = dog; // let both variables, animal and dog point to the new dog
} else {
    Cat cat = new Cat(); 
    cat.setF(..);
    cat.setG(..);
    animal = cat;
}

animal.setA(..); // modify either cat or dog using the animal methods
animal.setB(..);
animal.setC(..);

listAnimal.add(animal);