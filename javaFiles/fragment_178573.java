public class Customer {

    private long CustomerId;
    private String FName;
    private String LName;
    private String CarMake;
    private String CarModel;
    private Double CarCost;

    public Customer(String first_name, String last_name, String make_of_car, String model, Double cost) {
        this.FName = first_name;
        this.LName = last_name;
        this.CarMake = make_of_car;
        this.CarModel = model;
        this.CarCost = cost;
    }

    public Customer() {
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getFName() {
        return FName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getLName() {
        return LName;
    }

    public void set_CarMake(String carMake) {
        CarMake = carMake;
    }

    public String get_CarMake() {
        return CarMake;
    }

    public void set_CarCost(Double carCost) {
        CarCost = carCost;
    }

    public Double get_CarCost() {
        return CarCost;
    }

    public void set_CarModel(String carModel) {
        CarModel = carModel;
    }

    public String get_CarModel() {
        return CarModel;
    }

    public void setCustomerId(long customerId) {
        CustomerId = customerId;
    }

    public long getCustomerId() {
        return CustomerId;
    }

    public long getID() {
        return this.getCustomerId();
    }

    public void setID(long id) {
        this.setCustomerId(id);
    }
}