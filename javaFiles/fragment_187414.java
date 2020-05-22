for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
        Type listType = new TypeToken<List<String>>() {}.getType();
        List<String> players = context.deserialize(entry.getValue(), listType);
        WynnWorld wynnWorld = new WynnWorld(players);
        list.add(wynnWorld);
    }