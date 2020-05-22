String myJson = "[{\"id\":4,\"quantity\":2,\"product\":{\"id\":2,\"productName\":\"Audi R8\",\"description\":\"The best of Audi\",\"cost\":1000000.0,\"rrp\":1500000.0,\"product_category\":[{\"id\":2,\"category\":{\"id\":1,\"categoryname\":\"Supercars\"}},{\"id\":3,\"category\":{\"id\":2,\"categoryname\":\"Sportscars\"}}]}}]";
    JsonElement jsonElement = new JsonParser().parse(myJson);
    // This is because your json string is an array {}
    JsonArray myJsonAsArray = jsonElement.getAsJsonArray();
    // Now inside the json array, you get an object, so get it first from '0' index
    JsonObject mainObject = myJsonAsArray.get(0).getAsJsonObject();
    // Now you have a 'product' JsonObject inside the main object
    // You can directly get it by using String name
    JsonObject productObject = mainObject.getAsJsonObject("product");
    // Once you have 'Product' object, you can get individual elements by following
    String productName = productObject.get("productName").getAsString();
    // This will print out "Audi R8"
    System.out.println(productName);

    //You know how it works. Now get other individual elements of the product object by name