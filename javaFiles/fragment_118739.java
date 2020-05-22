public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
    /**
     * Tune the code further..
     */
    ShoppifyProductResponse products = new ShoppifyProductResponse();
    List<ShoppifyProduct> lst = new ArrayList<ShoppifyProduct>();
    while (reader.hasMoreChildren()) {
        reader.moveDown();
        ShoppifyProduct thisProduct = (ShoppifyProduct) context.convertAnother(products,
                ShoppifyProduct.class);
        lst.add(thisProduct);
        reader.moveUp();
    }
    products.setProducts(lst);
    return products;
}