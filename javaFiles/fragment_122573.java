public class AmericanCar
{

    //...
    private EuropeanCar internalEuropeanCar;

    //...
    public double getCurrentSpeed()
    {
        return AmericanCar.convertKilometerToMiles(this.internalEuropeanCar.getCurrentSpeed());
    }

    private static double convertKilometerToMiles(double currentSpeed)
    {
        // ...
        return CONVESION_VALUES;
    }   

    //...
}