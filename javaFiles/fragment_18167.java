public class Manufacturer
{
    private String manufacturerName;    // manufacturer of the car
    private Car[] cars;                 // an array to store the cars
    private int numOfCars;
    //default constructor initialize car array size to 10
    //and the current numOfCar to 0
    public Manufacturer()
    {
        numOfCars = 0;
        cars = new Car[10];
    }

    // getter methods for manufacturer
    public String getManufacturerName()
    {
        return manufacturerName;
    }

    public void setManufacturer(String aManufacturer)
    {
        manufacturerName = aManufacturer;
    }

    public Manufacturer getManufacturer() {
        return this;
    }

    public Car[] getCars() {
        return cars;
    }

    public void addCar(Car car){
        cars[numOfCars] = car;
        numOfCars++;
    }


    public int getNumOfCars() {
      return numOfCars;
    }
}