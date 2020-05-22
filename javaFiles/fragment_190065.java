public class JacksonExample {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        String text = "{ \"id\": 8029390, \"user\": { \"username\": \"Skrillex\" } }";

        ObjectMapper mapper = new ObjectMapper();
        Pojo pojo = mapper.readValue(text, Pojo.class);

        System.out.println(pojo.id);
        System.out.println(pojo.user.username);
    }
}

class Pojo {
    public String id;
    public User user;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public static class User {
        public String username;

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
    }
}