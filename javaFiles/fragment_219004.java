public class NotEmptyAlphaNumericValidator implements Converter<String, String> {

    // Validation
    public String to(String userObject) {
        assertNotEmpty(userObject);
        assertMatches(userObject, "^[a-zA-Z0-9_]*$");
        return userObject;
    }

    // Boilerplate
    public String from(String databaseObject) { return databaseObject; }
    public Class<String> fromType() { return String.class; }
    public Class<String> toType() { return String.class; }
}