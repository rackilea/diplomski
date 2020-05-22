JsonObject settings;
JsonObject defaultSettings;

static JsonElement getSetting(String key){
    String[] args = key.split("\\.");
    JsonObject curr = settings;
    for(int i = 0; i < args.length - 1; i++){
        curr = curr.getAsJsonObject(args[i]);
    }
    if(curr.has(args[args.length - 1]))
        return curr.get(args[args.length - 1]);
    else
        return getGuildSetting(gId, key, defaultSettings);
}
static JsonElement getSetting(String key, JsonObject jsonObject){
    String[] args = key.split("\\.");
    JsonObject curr = jsonObject;
    for(int i = 0; i < args.length - 1; i++){
        curr = curr.getAsJsonObject(args[i]);
    }
    return curr.get(args[args.length - 1]);
}

static void setSetting(String key, Object val){
    String[] args = key.split("\\.");
    JsonElement emptyElement = new Gson().fromJson("{}", JsonElement.class);
    JsonObject curr = settings;
    for(int i = 0; i < args.length - 1; i++){
        if(!curr.keySet().contains(args[i])) curr.add(args[i], emptyElement);
        curr = curr.getAsJsonObject(args[i]);
    }
    curr.add(args[args.length - 1], new Gson().toJsonTree(val));
}