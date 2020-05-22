public abstract class Bird
{
    protected BirdCallStrategy callStrat;
    protected FlyStrategy flyStrat;
}

public class Duck
{
    public Duck()
    {
        callStrat = new QuackStrategy();
        flyStrategy = new FlySouthForWinterStrategy(TimeOfYear);
    }
}

public class Chicken
{
    public Chicken()
    {
        callStrat = new CluckStrategy();
        flyStrat = new NoFlyStrategy();
    }
}