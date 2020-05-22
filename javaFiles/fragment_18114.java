public class FuelGague {

    private double amount;
    // Starting amount of fuel
    public FuelGague(double amount) {
        this.amount = amount;

    }
    // Not sure if you really need this method for your solution. This is classic setter method.
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
    // I guess this is what do you actually want to do 
    public void changeAmount(double difference) {
        amount += difference;
    }

}


public class Mileage  {

       private FuelGague fuelGague;

       public Mileage(FuelGague fuelGague) {
           this.fuelGague = fuelGague;
       }
       // This will be main method where you can decrease amount for guelGague
       public void methodForMileage() {
        fuelGague.changeAmount(-1);
       }

        public FuelGague getFuelGague() {
        return fuelGague;
    }

    public void setFuelGague(FuelGague fuelGague) {
        this.fuelGague = fuelGague;
    }

     public static void main(String[] args) 
     { 
            FuelGague fuelGague= new FuelGague(50); 
            Mileage mil = new Mileage(fuelGague);     
     } 
}