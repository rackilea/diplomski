public class PasswordChecker {

    private final String secretPassword;

    public PasswordChecker(String secretPassword) {
        this.secretPassword = secretPassword;
    }

    public boolean test(String password) {
        return Objects.equals(this.secretPassword, password);
    }

}