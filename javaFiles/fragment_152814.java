public Zoo (String animal, String food) throws AnimalException {
    this.animal = animal;
    if (findWord(animal, "wolf")) {
        throw new AnimalException("This animal is a predator.");
    }
    else {
        this.food = food;
    }
}

void foo() {
    Zoo myZoo;
    try {
        myZoo  = new Zoo("wolf", "meat");
    } catch (AnimalException ex) {
        System.out.println(ex.toString())
    }
    // myZoo is still null, uninitialized.
}