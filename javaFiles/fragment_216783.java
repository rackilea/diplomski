JSONObject jsonObj = new JSONObject();
jsonObj.put("name", name);
jsonObj.put("hobby", hobby);

JsonParser parser = new JsonParser();
JsonObject json = parser.parse(jsonObj.toString()).getAsJsonObject();
Gson gson = new GsonBuilder().setPrettyPrinting().create();
System.out.println(gson.toJson(json));