Gson gson = new Gson();

// 1. JSON to Java object, read it from a file.
Staff staff = gson.fromJson(new FileReader("D:\\file.json"), Staff.class);

// 2. JSON to Java object, read it from a Json String.
String jsonInString = "{'name' : 'mkyong'}";
Staff staff = gson.fromJson(jsonInString, Staff.class);

// JSON to JsonElement, convert to String later.
JsonElement json = gson.fromJson(new FileReader("D:\\file.json"), JsonElement.class);
    String result = gson.toJson(json);


Gson gson = new Gson();
String jsonInString = "{\"userId\":\"1\",\"userName\":\"Yasir\"}";
User user= gson.fromJson(jsonInString, User.class);