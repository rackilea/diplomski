public class PetList{
    private List<Pet> pets;//now this is an instance variable

    public PetList(){
        this.pets = new ArrayList<Pet>();//this list is not local now
        Puppies spot = new Puppies();
        Puppies rex = new Puppies();
        Kittens meowth = new Kittens();
        pets.add(spot);
        pets.add(rex);
        pets.add(meowth);
    }

    public void eatAll() { //method to invoke eat() on list of pets
        for(Pet pet : this.pets) { //iterate the pets list
            pet.eat();//call eat() on each pet object
        }
    }

    public static void main(String[] args){
          PetList petList = new PetList();
          petList.eatAll();//invoke the eatAll() method
     }
}