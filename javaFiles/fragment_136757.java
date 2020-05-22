public class Main {

    public static void main(String[] args) throws Exception {
        String json
                = "{\n"
                + "    \"newsletter\": {\n"
                + "        \"key1\": \"value1\",\n"
                + "        \"key2\": \"value2\",\n"
                + "        \"key3\": \"value3\"\n"
                + "    }\n"
                + "}";

        ObjectMapper mapper = new ObjectMapper();
        Preferences prefs = mapper.readValue(json, Preferences.class);
        Map<String, String> properties = prefs.getNewsletter().getProperties();
        for (Map.Entry<String, String> prop: properties.entrySet()) {
            System.out.println(prop.getKey() + ":" + prop.getValue());
        }
    }
}