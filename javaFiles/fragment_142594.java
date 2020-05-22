for(Product product: products) {
    for(Store store: product.stores) {
        Document doc = new Document();
        doc.add(new TextField("productName", product.name, Field.Store.YES));
        doc.add(new FloatField("price", price, Field.Store.YES));
        doc.add(new TextField("store", store, Field.Store.YES));
        doc.add(new TextField("location", location, Field.Store.YES));
    }
}