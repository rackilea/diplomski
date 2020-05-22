public class UserViewA {

    @JsonUnwrapped
    private User user;

    public User getUser() ...

    public String getFullName() {
        return user.getFirstName() + " " + user.getLastName()
    }
}