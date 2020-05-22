public class UserProfileEditor extends PropertyEditorSupport  {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        ObjectMapper mapper = new ObjectMapper();

        UserProfile value = null;

        try {
            value = new UserProfile();
            JsonNode root = mapper.readTree(text);
            value.setEmail(root.path("email").asText());
        } catch (IOException e) {
            // handle error
        }

        setValue(value);
    }
}