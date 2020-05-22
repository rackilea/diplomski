public class Automobile
{
    private int fuel = 0;
    public void giveFuel(int amount)
    {
        fuel += amount;
    }
}
public class Car extends Automobile
{
}
public class Porche extends Car
{
}