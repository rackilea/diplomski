public class Car
{

    private int year;           // year of the car
    private String model;       // model of the car
    private double price;       // price of the car
    private int kmTravelled;    // the KM travelled by the car
    private String extras;      // extra information about the car


    public Car()
    {

    }

    // Parameterized constructor
    public Car(int year, String model, double price,int kmTravelled, String extras )
    {
        this.year = year;
        this.model = model;
        this.price = price;
        this.kmTravelled = kmTravelled;       
        this.extras = extras;
    }

    // getter method for Year
    public int getYear()
    {
        return year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getKmTravelled() {
        return kmTravelled;
    }

    public void setKmTravelled(int kmTravelled) {
        this.kmTravelled = kmTravelled;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public void setYear(int year) {
        this.year = year;
    } 


}