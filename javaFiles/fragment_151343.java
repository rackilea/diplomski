public class Dog extends Animal
{
    ...
    static
    {
        AnimalFactory.instance().registerAnimal(ID.DOG, Dog.class);
    }
    ...
}