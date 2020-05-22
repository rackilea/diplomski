@JsonFilter("roleBasedPropertyFilter")
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @RolesAllowed({"ADMIN"})
    public String getEmail() {
        return email;
    }

    @DenyAll
    public String getPassword() {
        return password;
    }

    // Other getters and setters
}