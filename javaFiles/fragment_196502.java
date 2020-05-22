public class UserValidatorStub extends UserValidator {

    private String expectedUsername;
    private boolean isValidUsername;

    public UserValidatorStub(String expectedUsername, boolean isValidUsername){
          this.expectedUsername = expectedUsername;
          this.isValidUsername = isValidUsername;
    }
    public boolean isValidUsername(String username) {
        if (username.equals(expectedUsername)){
           return isValidUsername;
        }
        // as fallback, it uses the default implementation but you may return false or null as alternative
       return super.isValidUsername(username);
    }

}