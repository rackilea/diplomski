public class Product {
    String name;
    double price;
    int qty;

    public Product(String name, double price, int qty) {
        this.name = name; this.price = price; this.qty = qty;
    }

    public Product merge(Product p) {
        price += p.price;
        qty += p.qty;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s x %d (%.2f)", name, qty, price);
    }
}