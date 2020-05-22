public boolean keyExists(JSONObject  object, String searchedKey) {
    boolean exists = object.has(searchedKey);
    if(!exists) {      
        Iterator<?> keys = object.keys();
        while( keys.hasNext() ) {
            String key = (String)keys.next();
            if ( object.get(key) instanceof JSONObject ) {
                    exists = keyExists(object.get(key), searchedKey);
            }
        }
    }
    return exists;
}

Object obj=JSONValue.parse(str);
JSONObject json = (JSONObject) obj;
System.out.println(keyExists(json, "country")); //Returns true