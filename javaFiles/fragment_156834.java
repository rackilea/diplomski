String json="" // place your json format here in double Quotes with proper escapes .......
jObject = new JSONObject(json.trim());
Iterator<?> keys = jObject.keys();

while( keys.hasNext() ) {
    String key = (String)keys.next();
    if ( jObject.get(key) instanceof JSONObject ) {
         // do what ever you want with the JSONObject.....
    }
}