String case1 = "{'field':false}";
String case2 = "{'field':[1,2,3,4]}";
JsonElement jsonElement = ((JsonObject)(new JsonParser().parse(case1))).get("field");

if(jsonElement instanceof JsonArray) {
    JsonArray jsonArray = (JsonArray)jsonElement;
    if(jsonArray != null && jsonArray.size() > 0) {
        for (JsonElement aJsonElement : jsonArray) {
            // TODO: handle json element inside array 
            System.out.println(aJsonElement);
        }
    }
} else if (jsonElement instanceof JsonPrimitive) {
    boolean value = jsonElement.getAsBoolean();
    System.out.println("value:" + value);
}