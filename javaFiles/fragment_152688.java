JsonElement jelement = new JsonParser().parse(response);
JsonObject  jobject = jelement.getAsJsonObject();
String ordersString = jobject.get("orders").getAsString();

Gson gson = new Gson();
Type listType = new TypeToken<List<Order>>() {}.getType();
modelData = gson.fromJson(ordersString, listType);