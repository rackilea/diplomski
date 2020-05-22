final String name = "foo";
List<Product> products = searchItem(list, new ProductAccepter() {
    public boolean accept(Product product) {
        return product.getName().toLowerCase().contains(name.toLowerCase());
    }
});