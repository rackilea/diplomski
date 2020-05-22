public List <Product> getProducts(String prodId, String prodName) {

    // TODO add like statement to SimpleSelectBuilder
    return new SimpleSelectBuilder<Product>(this.getEntityManager(), Product.class)
           .and(Product_.prodId, prodId))
           .and(Product_.prodName, prodName))
           .getResultList();

}