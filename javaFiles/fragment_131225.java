public class Dog extends Animal
{
    private String breed;

    public Dog(int color, int weight, String breed)
    {
        super(color,weight); //let superclass initialize these.
        this.breed = breed;
    }
}