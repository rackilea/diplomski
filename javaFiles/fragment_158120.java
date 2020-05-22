FindIterable<Document> cursor = collection.find(Filters.eq("IDVenta", 1));

for (Document document : cursor) {
    // the lineaCompra attribute is an array of sub documents
    // so read it as a List and then iterate over that List
    // with each element in the List being a Document
    List<Document> lineaCompra = document.get("lineaCompra", List.class);
    for (Document d : lineaCompra) {
        System.out.println("idProducto: " + d.get("idProducto"));
        System.out.println("cantidad: " + d.get("cantidad"));
        System.out.println("precio: " + d.get("precio"));
        System.out.println("----");
    }
}