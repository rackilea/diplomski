class CarTest {
    private String make;
    private String model;
    private int year;
    private int price;
    private String color;
    private String size;

    public CarTest() {
        this.make = "somevalue";
        this.model = "somevalue";
        this.year = 2017;
        this.price = 50000;
        this.color = "somecolor";
        this.size = "somesize";
    }

    public CarTest(String make, String model){
        this.make = make;
        this.model = model;
    }


    public String getMake() {
       return make;
    }

    public void setMake(String make) {
       this.make = make;
    }

    public String getModel() {
       return model;
    }

    public void setModel(String model) {
       this.model = model;
    }

    public int getYear() {
       return year;
    }

    public void setYear(int year) {
       this.year = year;
    }

    public int getPrice() {
       return price;
    }

    public void setPrice(int price) {
       this.price = price;
    }

    public String getColor() {
       return color;
    }

    public void setColor(String color) {
       this.color = color;
    }

    public String getSize() {
       return size;
    }

    public void setSize(String size) {
       this.size = size;
    }

    @Override
    public String toString() {
    return "CarTest{" +
            "make='" + make + '\'' +
            ", model='" + model + '\'' +
            ", year=" + year +
            ", price=" + price +
            ", color='" + color + '\'' +
            ", size='" + size + '\'' +
            '}';
    }
}