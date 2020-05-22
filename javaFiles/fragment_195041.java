public class CarDashboard
{
    public int currentSpeed;
    public int fuelPercentage;    
    //etc...
}

public class FuelObserver extends Observer
{
   private CarDashboard dashboard;

   public FuelObserver(CarDashboard dashboard)
   {
      this.dashboard = dashboard;
   }

   public void update(Observable fuelTank, Object fuelLevel)
   {
       this.dashboard.fuelPercentage = (int)fuelLevel;
   }
}

//etc..