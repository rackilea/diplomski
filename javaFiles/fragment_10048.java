public class User {
    @JsonView({Admin.class})
    private long id;

    @JsonView({Basic.class})
    private String username;

    @JsonIgnore
    private String password;

    @JsonView({Basic.class})
    private String someCommonData;

    @JsonView({Admin.class})
    private String someAdminData;

    static class Basic {
    }

    static class Admin extends Basic {
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();


        User user = new User();
        user.id = 1L;
        user.username = "admin";
        user.password = "nimda";
        user.someCommonData = "common-data";
        user.someAdminData = "admin-data";

        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

        System.out.println(writer.withView(Basic.class).writeValueAsString(user));
        System.out.println(writer.withView(Admin.class).writeValueAsString(user));
    }
}