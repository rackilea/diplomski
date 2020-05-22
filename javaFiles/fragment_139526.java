public class Animal
{
    public final String name;
    public final int weight;

    public Animal(String name, int weight)
    {
        this.name = name;
        this.weight = weight;
    }

    public void jump()
    {
        System.out.println(name + " Jumped");
    }
}