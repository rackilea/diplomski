public class MyDeserializer implements JsonDeserializer<Groups> {
    private final String groups_key = "groups";

    @Override
    public Groups deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Groups groups = new Groups();
        JsonObject object = json.getAsJsonObject().getAsJsonObject(groups_key);
        Map<String, Group> retMap = new Gson().fromJson(object, new TypeToken<HashMap<String, Group>>() {}.getType());

        List<Group> list = new ArrayList<Group>(retMap.values());
        groups.userList = list;

        return groups;
    }
}