import com.example.stackoverflow.domain.Product;
    import com.example.stackoverflow.repository.ProductRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Component;
    import java.util.List;

    @Component
    public class ProductServiceImpl implements ProductService {

        @Autowired
        private ProductRepository productRepository;

        public Product findByName(String name) {
            return productRepository.findByName(name);
        }

        public List<Product> getAllProducts() {
            return productRepository.getAllProducts();
        }
    }