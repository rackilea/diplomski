public static void main(String[] args) {
    System.out.println("How many animals you want to add..");
    Scanner an = new Scanner(System.in);
    int animalNumbers = an.nextInt();
    List<Animal> animals = new ArrayList<Animal>();
    for (int i = 0; i < animalNumbers; i++) {
        Animalcat = new animaltype();
        animals.add(Animalcat);
    }
    Display(animals);
}
//modify Display method accordingly