public class MinimizeJsonClient {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        user.setAge(30);
        user.setName("HenryXi");
        System.out.println(objectMapper.writeValueAsString(user));
    }
}