public class Battery
{

      private final double fullCharge;
      private double batteryCapacity;

public Battery(double capacity)
{

      if(capacity < 2000 || capacity > 3000)
          throw new Exception("Cannot create Battery as the capacity should be in betweeen 2000 and 3000");
      batteryCapacity = capacity;
      fullCharge = capacity;

}
public void drain(double amount) throws Exception
{
     if((batteryCapacity - amount) < 0 || (batteryCapacity - amount) > 3000) 
         throw new Exception("The amount is invalid as the battery capacity is going out of range");
     else 
              batteryCapacity = batteryCapacity - amount;
}

public void charge()
{

     batteryCapacity = fullCharge;
}

public double getRemainingCapacity()
{
     return batteryCapacity;
}

}