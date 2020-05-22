JsonArray data = new JsonArray();  //Creates Json Array

for (int i = 0; i< 10; i++) {
   JsonObject obj = new JsonObject(); //Create object and add values
   obj.addProperty("id", i);
   obj.addProperty("value", "Some value");

   data.add(obj); //Add object to array
}

String json = new Gson().toJsonTree(data).getAsJsonArray().toString(); //Convert array to String