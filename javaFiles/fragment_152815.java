public Zoo (String animal, String food) throws AnimalException {
    this.animal = animal;
    this.food = food;
    if (findWord(animal, "wolf")) {
        System.out.println("Beware, we have a predator in zoo");
    }
}