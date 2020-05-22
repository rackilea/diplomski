List<Product> productList = Lists.newArrayList();
for (int i = 0; i < 5; i++) {
    Product product = new Product();               
    product.setId("id:" + i);
    productList.add(product);
}