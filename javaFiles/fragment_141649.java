class PlayersAdapter implements JsonDeserializer<Players> {
    public Players deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext ctx) {
        List<Player> players = new ArrayList<>();
        for (Map.Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
            players.add(ctx.deserialize(entry.getValue(), Players.class));
        }
        return new Players(players);
    }
}


// ...
Gson gson = new GsonBuilder()
        .registerTypeAdapter(Players.class, new PlayersAdapter())
        .create();