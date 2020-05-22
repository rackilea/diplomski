JsonObject newJsonObject = new JsonObject();

newJsonObject.addProperty("customerid", "System.nanoTime()");//new property
newJsonObject.add("test_id", originalJSONString.get("test_id"));//copy property
newJsonObject.add("timestamp", originalJSONString.get("timestamp"));//copy property

System.out.println(gson.toJson(newJsonObject));