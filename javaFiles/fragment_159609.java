@Override
public Iterable<Product> saveProduct(Product product) {
    Product product1 = new com.adl.dte.core.model.Product();
    product1.setProductName(product.getProductName());
    product1.setPQty(product.getPQty());
    product1.setPrice(product.getPrice());
    product1.setCustomerList(product.getCustomerList());

    product.getCustomerList().forEach(cust -> cust.setProduct(product1));
    productRepository.save(product);
    return productRepository.findAll();
}