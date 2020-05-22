public static List<Product> getCartList() {

    JSONObject responseDetailsJson = new JSONObject();
    JSONArray jsonArray = new JSONArray();

    List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
    for(Product p : cartMap.keySet()) {
        cartList.add(p);
        JSONObject formDetailsJson = new JSONObject();
        formDetailsJson.put("id", "1");
        formDetailsJson.put("name", "name1");
       jsonArray.add(formDetailsJson);
    }
    responseDetailsJson.put("forms", jsonArray);//Here you can see the data in json format

    return cartList;

}