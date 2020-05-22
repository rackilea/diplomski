public static void main(String[] args) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Type type = (new TypeToken<Map<Key, Value>>() {}).getType();    
        builder.registerTypeAdapter(type, new JsonDeserializer<Map<Key, Value>>() {
          @Override
          public Map<Key, Value> deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
              Map<Key, Value> resultMap = new HashMap<>();
              JsonArray jArr = json.getAsJsonArray();
              for(int i=0; i < jArr.size(); i++){
                  JsonObject item = jArr.get(i).getAsJsonObject();
                  processKeyValue(item, resultMap);
              }
              return resultMap;
          }

          private void processKeyValue(JsonObject mapEntry, Map<Key, Value> resultMap){
              Gson gson = new Gson();
              Key key = gson.fromJson(mapEntry.get("key"), Key.class);
              Value value = gson.fromJson(mapEntry.get("value"), Value.class);
              resultMap.put(key, value);
          }
        });
        Gson gson = builder.create();

        //Note: assume that the variable "json" is a JSON string. I removed my code for getting the string since I'm just reading from a file and I don't know how you're getting your data.

        // Deserialization

        Map<Key,Value> outputMap = gson.fromJson(json, type);


        System.out.println("RESULTS: "+outputMap.toString());
    }