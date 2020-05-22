public List<Product> getAllProducts() {
    DBCursor cur = mongoCollection.find();
    List<Product> products = new ArrayList<Product>();
    while(cur.hasNext()) {
        products.add(cur.next());
    }
    return products;
}