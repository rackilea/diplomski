Gson gson = new Gson();

JsonArray jsonArray = gson.fromJson (jsonString, JsonElement.class).getAsJsonArray(); // Convert the Json string to JsonArray

JsonObject jsonObj = jsonArray.get(0).getAsJsonObject(); //Get the first element of array and convert it to Json object

Pojo pojo = gson.fromJson(jsonObj.get("data").toString(), Pojo.class); //Get the data property from json object and convert it to Pojo object