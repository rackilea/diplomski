public class ModelLogin {

    private final String userName;
    private final String password;

    ModelLogin(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }

    boolean isCorrectCredentials(String userName, String password){

        return this.userName.equals(userName)&&this.password.equals(password);
    }
}