public class User {
    private String username;
    private char[] password;
    public User(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    public String getUserName() {
        return username;
    }

    public char[] getPassword() {
        return password;
    }
}