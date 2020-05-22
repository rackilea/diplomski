import com.example.stackoverflow.domain.Product;
    import java.util.List;

    public interface ProductService {
        Product findByName(String name);
        List<Product> getAllProducts();
    }