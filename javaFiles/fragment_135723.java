...
Set<String> usedKeys = new HashSet<String>();
while (iter.hasNext()) {
    Map<String,String>forJson = new HashMap<String, String>();
    Statement stmt = iter.nextStatement();

    object = stmt.getObject();

    String key = object.asResource().getLocalName();
    if(!usedKeys.contains(key)) {
        usedKeys.add(key);
        forJson.put("key", key);
        forJson.put("value", object.asResource().getURI());
        array.add(forJson);
    }

    i++;
    System.out.println(i);
}