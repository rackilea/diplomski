class JsonService {

    public RootRecipes parseJson(json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        JsonRootRecipes jsonRootRecipes = mapper.readValue(json, JsonRootRecipes.class);

        RootRecipes rootRecipes = null; //convert jsonRootRecipes to RootRecipes

        return rootRecipes;
    }
}