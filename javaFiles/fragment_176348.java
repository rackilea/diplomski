import com.example.stackoverflow.domain.Product;
    import org.springframework.stereotype.Component;
    import java.util.Arrays;
    import java.util.List;

    @Component
    public class ProductRepositoryImpl implements ProductRepository {

        private List<Product> products = Arrays.asList(
                new Product("Coca Cola", "drink"),
                new Product("Pepsi", "drink"));

        public Product findByName(String name) {
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(name)) {
                    return product;
                }
            }
            return null;
        }

        public List<Product> getAllProducts() {
            return products;
        }
    }