public class Car {

    private String vin;
    private String model;

    Car() {
    }

    public Car(String vin, String model) {
        this.vin = vin;
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public String getModel() {
        return model;
    }   

    // toString ... 
}