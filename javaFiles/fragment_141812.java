class UsersResponseDeserializer extends JsonDeserializer<UsersResponse> {

    private Pattern propertyPattern = Pattern.compile("^part(\\d+)\\.(.+)$");

    @Override
    public UsersResponse deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        Integer lastIndex = null;
        String lastName = null;
        Map<Integer, Map<String, String>> users = new LinkedHashMap<>();
        while (p.currentToken() != null) {
            switch (p.currentToken()) {
                case FIELD_NAME:
                    String name = p.getText();
                    Matcher matcher = propertyPattern.matcher(name);
                    if (matcher.matches()) {
                        lastIndex = Integer.parseInt(matcher.group(1));
                        lastName = matcher.group(2);
                    }
                    break;
                case VALUE_STRING:
                    if (lastIndex != null && lastName != null) {
                        Map<String, String> user = users.computeIfAbsent(lastIndex, k -> new HashMap<>());
                        user.put(lastName, p.getValueAsString());
                        lastIndex = null;
                        lastName = null;
                    }
                    break;
                default:
                    break;
            }
            p.nextToken();
        }

        UsersResponse response = new UsersResponse();
        response.setUsers(users);

        return response;
    }
}