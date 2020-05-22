public static JSONObject getCarJSON(String id, String name, String price) {
    JSONObject carObj = new JSONObject();                   
    carObj.put("id", id);                    
    carObj.put("name", name);
    carObj.put("price", price);
    return carObj;
}