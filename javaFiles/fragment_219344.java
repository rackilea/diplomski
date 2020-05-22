private void productToJSON(Product product, JsonGenerator jsonGen) throws Exception {
    jsonGen.writeStartObject();
    jsonGen.writeStringField("name", product.getName());
    jsonGen.writeNumberField("weight", product.getWeight());
    jsonGen.writeNumberField("stock", product.getStock());
    jsonGen.writeNumberField("price", product.getPrice());
    jsonGen.writeNumberField("rating", product.getRating());
    jsonGen.writeEndObject();
}

public void productsToJSON(String fileName) throws Exception {
    JsonFactory jsonFactory = new JsonFactory();
    FileOutputStream file = new FileOutputStream(fileName);
    JsonGenerator jsonGen = jsonFactory.createJsonGenerator(file, JsonEncoding.UTF8);
    jsonGen.setPrettyPrinter(new DefaultPrettyPrinter());
    if (this.products.size > 1) {
        jsonGen.writeStartArray(this.products.size)
    }
    for (Product p: this.products) {
        this.productToJSON(p, jsonGen);
    }
    if (this.products.size > 1) {
        jsonGen.writeEndArray()
    }
    jsonGen.close();
}