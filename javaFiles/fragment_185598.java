String json = "{\"a\": 1, \"b\": 1}";
JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);

System.out.println(jsonObject); // {"a":1,"b":1}

jsonObject.addProperty("a", 2);
jsonObject.add("b", JsonNull.INSTANCE);
System.out.println(jsonObject); // {"a":2,"b":null}

jsonObject.remove("a");
System.out.println(jsonObject); // {"b":null}