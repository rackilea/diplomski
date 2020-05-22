public static void main(String[] args) {
    System.out.println("How many animals you want to add..");
    Scanner an = new Scanner(System.in);
    int animalNumbers = an.nextInt();
    animal[] addAnimal = new animal[animalNumbers];
    animaltype[] at = new animaltype[animalNumbers];
    for (int i = 0; i < animalNumbers; i++) {
        //at[i] = new animaltype();
        //Animalcat = at[i].getAnimalType();
        Animalcat = new animaltype();
        //for (int j = 0; j < 1; j++) {
        //    addAnimal[i][j] = new animal();
        //}
        addAnimal[i] = Animalcat;
    }
    Display(addAnimal, at);
}
//modify Display method accordingly