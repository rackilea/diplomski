public abstract class Mammal extends Animal
{
    public Mammal(String name, int weight)
    {
        super(name, weight);
    }

    public abstract void jumpMammal();

    @Override
    public final void jump()
    {
        jumpMammal();
    }
}