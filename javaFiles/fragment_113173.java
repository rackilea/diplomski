jObject = new JSONObject(contents.trim());
Iterator<?> keys = jObject.keys();
while( keys.hasNext() ){
String key = (String)keys.next();
if( jObject.get(key) instanceof JSONObject ){
//get the values
}
}