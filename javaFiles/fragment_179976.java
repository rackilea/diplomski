Map<String, JsonObject> map = new Gson().fromJson(json, new TypeToken<Map<String, JsonObject>>(){}.getType());
    for(Map.Entry e : map.entrySet()) {
        System.out.println(e.getKey());
        System.out.println(e.getValue());
    }
}