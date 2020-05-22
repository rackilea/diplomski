private static final Map<String,Supplier<Product>> productConstructors = new HashMap<>();
static {
    productConstructors.put("productA", productA::new);
    productConstructors.put("productB", productB::new);
}
private static Product createByString(String name) {
    Supplier<Product> constructor = productConstructors.get(name);
    if (constructor == null) {
        // Handle this?
        throw new IllegalArgumentException("name " + name + " is not a valid Product");
    }
    return constructor.get();
}