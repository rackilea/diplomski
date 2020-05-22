Map<String, String> hstoreMap = new HashMap<>();
hstoreMap.put("key1", "value1");
hstoreMap.put("key2", "value2");

PGobject jsonbObj = new PGobject();
jsonbObj.setType("json");
jsonbObj.setValue("{\"key\" : \"value\"}");