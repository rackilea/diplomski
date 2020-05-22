public ProductType createProductType(String val1, String val2, String val3) {
    // this should already be instantiated
    List<ProductTypeCreator> creators;
    return creators
       .stream()
       .filter(creator -> creator.isApplicable(val1, val2, val3))
       .map(creator -> creator.create(val1, val2, val3))
       .findFirst()
       .get();
}