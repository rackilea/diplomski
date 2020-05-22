for (int i=0;i<products.length();i++) {
    ProductsPojo pojo = new ProductsPojo();

    JSONObject product_object = products.getJSONObject(i);
    String name = product_object.getString("name");
    String price = product_object.getString("price");
    String product_id = product_object.getString("id");
    String sessionname = product_object.getString("sessionname");
    String image = product_object.getString("image");
    String categoryname = product_object.getString("categoryname");

    pojo.setName(product_object.getString("name"));
    pojo.setImage(product_object.getString("image"));
    pojoList.add(pojo);
}