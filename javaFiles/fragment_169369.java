class Zoo {

    private ArrayList<Animal> animals;

    //create a main method
    public static void main(String[] args) {

       Zoo zoo = new Zoo();//Create Zoo object
       Parrot parrot = new Parrot();
       zoo.addAnimal(parrot);//add parraot to list by calling addAnimal
    }

   public void addAnimal(Animal animal) {
     animals.add(animal);
   }
}