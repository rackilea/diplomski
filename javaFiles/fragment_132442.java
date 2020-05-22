public class CustomProductRepository implements ProductRepository {

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<Product>();
    }

    @Override
    public Product getProductById(String productId) {
        for (Product p : getAllProducts()) {
            if (p.getProductId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

}