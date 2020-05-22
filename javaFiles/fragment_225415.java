private final Catalog catalog; 
private final Basket basket;

@ParameterType("[a-z ]+")
public Catalog catalog(String name) {
  return catalogs.findCatalogByName(name);
}

@ParameterType("[a-z ]+")
public Product product(String name) {
  return catalog.findProductByName(name);
}

@Given("the {catalog} catalog")
public void the_catalog(Catalog catalog){
  this.catalog = catalog
}

@When("a user places the {product} in his basket")
public void a_user_place_the_product_in_his_basket(Product product){
  basket.add(product);
}