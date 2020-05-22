public class SignUpForm {
    //you can put some annotations here if you want for validating the email
    //for e.g @NotEmpty or a @Pattern(regexp to validate the email)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}