Map<String, JsonObject> HASH_MAP = new HashMap<>();

JsonObjectBuilder one = Json.createObjectBuilder();
one.add("test1","test1");
HASH_MAP.put("one", one.build());

JsonObjectBuilder two = Json.createObjectBuilder();
two.add("test2","test2");
HASH_MAP.put("two", two.build());

JsonObjectBuilder toReturn = Json.createObjectBuilder();
JsonArrayBuilder l1 = Json.createArrayBuilder();
for (Map.Entry<String, JsonObject> l : HASH_MAP.entrySet()) {
    l1.add(l.getValue());
}

toReturn.add("l1", l1);
toReturn.add("otherParam", "value2");
String strJSON = toReturn.build().toString();
System.out.println("JSON1: " + strJSON);
System.out.println("JSON2: " + HASH_MAP.get("one").toString());