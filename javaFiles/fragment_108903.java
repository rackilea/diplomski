public class Product extends MyClass{
    HashMap<Account.Property, String> property = new HashMap<>();
    public Product() {
    }

    public static enum Property {
        CODE,
        PRICE;
    }
}