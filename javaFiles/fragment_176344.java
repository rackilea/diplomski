import com.example.stackoverflow.domain.Product;
    import com.example.stackoverflow.service.ProductService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
    import org.springframework.context.annotation.ComponentScan;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.List;

    @RestController
    @EnableAutoConfiguration
    @ComponentScan("com.example.stackoverflow")
    public class ProductController {

        @Autowired
        ProductService productService;

        @RequestMapping(value = "/product/{name}", method = RequestMethod.GET)
        Product getByName(@PathVariable String name) {
            return productService.findByName(name);
        }

        @RequestMapping(value = "/products", method = RequestMethod.GET)
        List<Product> getProducts() {
            return productService.getAllProducts();
        }

        public static void main(String[] args) throws Exception {
            SpringApplication.run(ProductController.class, args);
        }
    }