for(Map.Entry<String, JsonElement> entry : results.entrySet()) {
        JsonArray array = entry.getValue().getAsJsonArray();
        for (JsonElement jsonElement : array) {
             for (Map.Entry<String, JsonElement> entry1 : jsonElement.getAsJsonObject().entrySet()) {
                 System.out.println("Key = " + entry1.getKey() + " Value = " + entry1.getValue() );
            }
        }