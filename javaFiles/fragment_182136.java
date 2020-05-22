private Long id;
private Product product;

public void init() {
    product = productService.find(id);
}