public class User{
    private String username;

    @JsonValue
    public String getJsonString() {
         return username;
    }

    @JsonCreator
    private static User parseJson(String jsonStr) {
        User u = new User();
        u.username = jsonStr;
        return u;
    }

    public static void main(String[] args) {
        User u = new User();
        u.userName = "Niraj";

        ObjectMapper m = new ObjectMapper();
        String jsonString = m.writeValueAsString(u);
        User u1 = m.readValue(jsonString, User.class);
    }
}