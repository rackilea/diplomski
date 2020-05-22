public class Dog extends Animal
{
    ...
    static
    {
        AnimalFactory.instance().registerAnimal(ID.DOG, new DogCreator());
    }
    ...
}

public class DogCreator extends AnimalFactory
{
    //Abstract factory method in AnimalFactory that gets called to return the Animal
    public Animal createAnimal
    {
        return new Dog();
    }
}