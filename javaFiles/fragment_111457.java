GsonBuilder gsonBuilder = new GsonBuilder();
gsonBuilder = gsonBuilder.setPrettyPrinting();   //Sets pretty formatting
Gson gson = gsonBuilder.create();                //Create Gson reference

JsonObject jsonObject = new JsonObject();
jsonObject.addProperty("description", "Hello. World");
jsonObject.addProperty("asfaf", "New. World");
jsonObject.addProperty("asfa", "Old. World");

System.out.println(gson.toJson(jsonObject));