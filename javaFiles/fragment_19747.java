public class TV {

    private int productionYear;
    private double price;

    public TV(int productionYear, double price) {
        this.productionYear = productionYear;
        this.price = price;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class Factory {

    public static int numberOfTV = 0;


    public TV produceTV(int a, double b) {
        TV tv = new TV(a, b);
        numberOfTV++;
        return tv;
    }


    public void printItems() {
        System.out.println("Number of TVs is: " + numberOfTV);

    }
}

public class Test {

    public static void main(String[] args) {

        Factory tvFactory = new Factory();
        TV tv = tvFactory.produceTV(2001, 399);
        tvFactory.printItems();

        // Do manipulation with tv reference here 

    }
}