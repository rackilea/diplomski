public class User {
    private String username;
    private String password;
    public User() {
        username = null;
        password = null;
    }

    public User getUser() {
        User user = new User();
        username = TexUsername.getText();
        return user;
    }
}