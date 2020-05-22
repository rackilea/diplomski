void find_text(JsonObject obj){
    Iterator<String> keys = jsonObject.keys();
    while (keys.hasNext()){
        String key = keys.next()
        if (key == "Text") {
            .. do your stuff ....
        } else if (obj.get(key) instanceof JSONObject) 
            find_text(obj.get(key))

      }
}