Map<String,String> data = new HashMap<>();

    for(JsonElement lst : messages) {
        JsonObject lstObject = lst.getAsJsonObject();
        JsonObject el = (JsonObject) lstObject.get("main");
        System.out.println(lstObject.get("dt_txt").getAsString()  +" "+el.get("temp").getAsString());
        data.put(lstObject.get("dt_txt").getAsString(), el.get("temp").getAsString()); 
    }