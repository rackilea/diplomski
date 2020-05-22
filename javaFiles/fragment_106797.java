public ProductModel(JsonObject json) {
    super();
    this.id = json.getInt("id");
    this.name = json.getString("name");
    this.manufacture = json.getString("manufacture");
    this.price = Double.parseDouble(json.getJsonNumber("price").toString());
    this.category = json.getString("category");
    this.type = json.getString("type");
    this.image = json.getString("image");
}