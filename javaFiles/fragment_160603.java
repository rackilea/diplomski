@GET
public ProductList getProducts(@QueryParam("near") String location) {
  // parse the locations variable
  List<Double> locations = Product.getLocation(location);
  // validate the value
  Set<ConstraintViolation<Product>> constraints = Validation
    .buildDefaultValidatorFactory()
    .getValidator()
    .validateValue(Product.class, "location", locations, Default.class);
    if (locations == null || locations.size() != 2
        || constraints.size() > 0) {
        throw new ConstraintViolationException(constraints);
    }
}