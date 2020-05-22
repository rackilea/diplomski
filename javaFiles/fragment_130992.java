public class Product {
    private String name;
    private double price;
    private Product[] ingredients;
    ...
    public Product(String name, double price, Product... ingredients) {
        // populate instance variables
    }
}