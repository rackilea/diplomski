import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

final class Product {
    private final String name;
    private final Double price;
    private final Double discount;

    Product(String name, Double price, Double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "{name=" + name + ", price=" + price + ", discount=" + discount + "}";
    }
}

public final class Main {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Watch", 45.99, 9.99));
        products.add(new Product("Keyboard", 21.99, 3.99));
        products.add(new Product("Mouse", 99.99, 4.99));

        System.out.println("Original items Before shuffle are");
        products.forEach(System.out::println);

        Collections.shuffle(products);
        System.out.println("Original items After shuffle are");
        products.forEach(System.out::println);
    }
}