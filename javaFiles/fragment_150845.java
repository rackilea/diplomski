public class LoginBean {

    @Size(min = 2, max = 20, message = "Must be betwen 2 and 20 chars")
    private String login;
    @Size(min = 1, message = "Please Enter your password")
    private String password;

    //getters and setters...

    public String userLogin() {
        //user login code
    }
}