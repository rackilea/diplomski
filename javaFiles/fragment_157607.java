class FlickrAccountJsonDeserializer extends JsonDeserializer<FlickrAccount> {

    @Override
    public FlickrAccount deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Root root = jp.readValueAs(Root.class);

        FlickrAccount account = new FlickrAccount();
        if (root != null && root.user != null) {
            account.setId(root.user.id);
            if (root.user.username != null) {
                account.setUsername(root.user.username.content);
            }
        }

        return account;
    }

    private static class Root {

        public User user;
        public String stat;
    }

    private static class User {

        public String id;
        public UserName username;
    }

    private static class UserName {

        @JsonProperty("_content")
        public String content;
    }
}