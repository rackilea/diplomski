import static java.util.Arrays.*;
import java.util.*;

public class UniqProd {
    public static class Product {
        String name;
        double price;
        int qty;

        public Product(String name, double price, int qty) {
            this.name = name;
            this.price = price;
            this.qty = qty;
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

    public static void main(String[] args) {
        List<Set<Product>> sets = asList(
            new HashSet<>(asList(new Product("cheese", 5, 1), new Product("milk", 3, 3))),
            new HashSet<>(asList(new Product("peanut", 1, 1), new Product("bread", 2, 1))),
            new HashSet<>(asList(new Product("cheese", 5, 1), new Product("peanut", 1, 1)))
        );

        listProducts(sets).forEach(System.out::println);
    }

    private static Collection<Product> listProducts(List<Set<Product>> sets) {
        Map<String, Product> uniques = new HashMap<>();
        for (Set<Product> set : sets)
            for (Product p : set)
                uniques.merge(p.name, p, (a, b) -> a.merge(b));
        return uniques.values();
    }
}