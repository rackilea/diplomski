JsonParser parser = new JsonParser();
JsonObject rootObject = parser.parse(JSON_STRING).getAsJsonObject();
//You can get the "open" and "total_products" here too.//
JsonElement productElement = rootObject.get("product");

Gson gson = new Gson();
List<Product> productList = new ArrayList<>();
//Check if "data" element is an array or an object and parse accordingly...
if (productElement.isJsonObject()) {
//The returned list has only 1 element
Product p = gson.fromJson(productElement, Product.class);
productList.add(p);
}
else if (productElement.isJsonArray()) {
//The returned list has >1 elements
Type productListType = new TypeToken<List<Product>>() {}.getType();
productList = gson.fromJson(productElement, productListType);
}