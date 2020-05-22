public static void getRootNodeOfJSONObject() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "{\"yes\":{\"en\": \"Yes\",\"de\": \"Ja\"},\"no\": {\"en\": \"No\",\"de\": \"Nein\"}}";
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode jsonNodeRoot = objectMapper.readTree(jsonString);

        for (Iterator key = jsonNodeRoot.fields(); key.hasNext();) {
            String text = key.next().toString();
            if(text.contains("Nein"))
            {
                String rootElement = text.substring(0, text.indexOf("="));
                System.out.println("Root element: " + rootElement);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        getRootNodeOfJSONObject();
    }