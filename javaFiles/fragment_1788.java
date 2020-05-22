public class Player {
    protected List<Pet>        petList = new ArrayList();
    protected Map<Integer,Pet> petMap =  new HashMap();

    public List<Pet> getPets() {return petList;}
    public Pet getPetById (int id) {return petMap.get( id);}
    public void addPet (Pet pet) {
        petList.add( pet);
        petMap.put( pet.getId(), pet);
    }
}

public class Pet {
    protected int id;
    // Id;
    public int getId() {return id;}

    // create;  static factory.
    //
    public static Pet createPet() {
        Pet pet = new Pet();
        pet.id = KeyAllocator.alloc("pet");
        return pet;
    }
}