for (int i = 0; i < jsonArray.length(); i++) {
    JSONObject jsonObject = jsonArray.getJSONObject(i);
    Iterator<String> keys = jsonObject.keys();
    while (keys.hasNext()) {
        String key = keys.next();
        Object value = jsonObject.get(key);
        System.out.println(key);
        System.out.println(value);
    }
}