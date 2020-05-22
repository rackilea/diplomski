class Car
{
    private double efficiency;
    private double fuel;

    public Car(double mpg, double initFuel)
    {
        this.efficiency = mpg;
        this.fuel = initFuel;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public double getEfficiency() {
        return efficiency;
    }

    // Same thing for fuel...
}