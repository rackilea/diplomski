public class MyJsonDeserializer implements JsonDeserializer<MyModel> {
@Override
public MyModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    Gson gson = new GsonBuilder().create();
    MyModel myModel = new MyModel();
    Iterator it = ((JsonObject) json).entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry entry = (Map.Entry) it.next();
        if (entry.getValue() instanceof JsonArray) {
            JsonArray myModelJsonArray = (JsonArray) entry.getValue();
            MyModel2 mymodel2 = new MyModel2();
            if (entry.getKey() instanceof String) {
                mymodel2.setName((String) entry.getKey());
            }
            for (int i = 0; i < myModelJsonArray.size(); i++) {
                JsonElement jsonElementMember = myModelJsonArray.get(i);
                mymodel2.getMembers().add(gson.fromJson(jsonElementMember, Member.class));
            }
            myModel.getMyModel2().add(myModel2);
        }
    }
    return myModel;
}