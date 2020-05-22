public class Coinbase {

    private double price = 0.0;

    public Coinbase(double price) {
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}