String key = object.asResource().getLocalName();
String value = object.asResource().getURI();
String unique = key + "|@|@|" + value;
if(!usedKeys.contains(unique)) {
    usedKeys.add(unique);
    forJson.put("key", key);
    forJson.put("value", value);
    array.add(forJson);
}