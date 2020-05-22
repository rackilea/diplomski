String json = "{ 'abcd': { 'a':'d' }, 'dcba': { 'd':'a' } }";
    JsonObject o = new JsonParser().parse(json).getAsJsonObject();

    for(Map.Entry<String, JsonElement> entry : o.entrySet()) {
        System.out.println(entry.getKey());
        System.out.println(entry.getValue());
    }