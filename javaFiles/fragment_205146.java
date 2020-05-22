public class JacksonNestedList {
    public final static String JSON = "{\n"
            + "    meta: {\n"
            + "        code: 200\n"
            + "    },\n"
            + "    response: {\n"
            + "        suggestedFilters: { },\n"
            + "        suggestedRadius: 922,\n"
            + "        headerLocation: \"New York\",\n"
            + "        headerFullLocation: \"New York\",\n"
            + "        headerLocationGranularity: \"city\",\n"
            + "        totalResults: 246,\n"
            + "        groups: [\n"
            + "            {\n"
            + "                type: \"Recommended Places\",\n"
            + "                name: \"recommended\",\n"
            + "                items: [\n"
            + "                    {\n"
            + "                        key: \"value1\"\n"
            + "                    },\n"
            + "                    {\n"
            + "                        key: \"value2\"\n"
            + "                    }\n"
            + "                ]\n"
            + "            }\n"
            + "        ]\n"
            + "    }\n"
            + "}";

    public static class GroupItem {
        public String key;

        @Override
        public String toString() {
            return "key:" + key;
        }
    }

    public static void main(String[] args) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        final JsonParser items = mapper.readTree(JSON)
                .path("response")
                .path("groups")
                .get(0)
                .path("items")
                .traverse();
        System.out.println(mapper.readValue(items, new TypeReference<List<GroupItem>>() {}));
    }
}