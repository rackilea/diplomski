public class User {

    private int id;
    private String username;
    private String fullname;
    private String gender;
    private String password;
    private String email;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;

    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getFullname() {
        return fullname;

    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;

    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
}