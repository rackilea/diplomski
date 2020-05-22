public static void main(String[] args) throws JsonProcessingException {
    User user = new User(1L, "Mike");
    ObjectMapper om = new ObjectMapper();
    om.writeValueAsString(user);
    System.out.println(om.writeValueAsString(user));
}