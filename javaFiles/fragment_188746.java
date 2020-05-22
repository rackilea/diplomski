package whatever;

public class Car {
    private String name;
    private String brand;

    // Getters and Setters
    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return this.name;
    }

    public void setBrand(String b) {
        this.brand = b;
    }

    public String getBrand() {
        return this.brand;
    }

    public Car(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car [Name=" + name + ", Brand=" + brand + "]";
    }

}