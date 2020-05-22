for (int j = 0; j < js.length(); j++) {
    JSONObject ob = js.getJSONObject(j);
    HashMap<String, Object> hash_addd = new HashMap<>();
    hash_addd.put("image1", ob.getString("0"));
    hash_addd.put("image2", ob.getString("1"));
    hash_addd.put("image3", ob.getString("2"));
    hash_store_image.add(hash_addd);
    items_store_image = new String[hash_store_image.size()];
}