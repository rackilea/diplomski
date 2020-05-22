public abstract class MammalStuff implements AnimalStuff{
    // no need to override unless there are mammal specific stuff
    public void doAnimal(){...}
}

public abstract class BirdStuff implements AnimalStuff{
    // example of bird specific
    @Override
    public void doAnimal(){
        System.out.println("I believe I can fly!!!");
    }
}