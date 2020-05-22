interface ICar
{
    void doSomething();
    void getFuel();
}

class GasCar : ICar
{
    public void doSomething()
    {
        //do something a gas car would do
    }
    public void getFuel()
    {
        //logic to pull gas out of a tank
    }
}

class ElectricCar : ICar
{
    public void doSomething()
    {
        //do something an electric car would do
    }
    public void getFuel()
    {
        //logic to pull fuel out of a battery
    }
}