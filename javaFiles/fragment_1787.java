@POST
@Consumes({MediaType.APPLICATION_JSON})
@Path("register")
public Response register(User user) {
    System.out.println("username: " + user.getUsername() );
    System.out.println("password: " + user.getPassword() );
    System.out.println("email: " + user.getEmail() );
}

public class User{
    private String username = null;
    private String password= null;
    private String email = null;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    } 
}