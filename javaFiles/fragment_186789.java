class EpisodesDetailDeserializer implements JsonDeserializer<EpisodesDetail> {

    @Override
    public EpisodesDetail deserialize(final JsonElement json, final Type typeOfT,
            final JsonDeserializationContext context) throws JsonParseException {

        EpisodesDetail geometry = new EpisodesDetail();
        JsonObject jsonObject = json.getAsJsonObject();
        int season = jsonObject.get("season").getAsInt();
        geometry.setSeason(season);

        List<Boolean> episodes = new ArrayList<Boolean>();
        Set<Entry<String, JsonElement>> set = jsonObject.get("episodes").getAsJsonObject()
                .entrySet();

        Iterator<Entry<String, JsonElement>> it = set.iterator();
        while (it.hasNext()) {
            episodes.add(it.next().getValue().getAsBoolean());
        }
        geometry.setEpisodes(episodes.toArray(new Boolean[] {}));
        return geometry;
    }
}

BufferedReader reader = new BufferedReader(new FileReader(new File("json.txt")));
EpisodesDetail episodesDetail = new GsonBuilder()
        .registerTypeAdapter(EpisodesDetail.class, new EpisodesDetailDeserializer())
        .create().fromJson(reader, EpisodesDetail.class);

System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(episodesDetail));