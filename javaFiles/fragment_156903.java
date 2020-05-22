public class LoginController {

    @FXML
    private Label loginMessage ;

    private final BooleanProperty loggedIn = new SimpleBooleanProperty();
    public BooleanProperty loggedInProperty() {
        return loggedIn ;
    }

    public final boolean isLoggedIn() {
        return loggedInProperty().get();
    }

    public final void setLoggedIn(boolean loggedIn) {
        loggedInProperty().set(loggedIn);
    }

    @FXML
    private void handleLogin() {
        // existing code you had in the previous version...
        if (count == 1) {
            System.out.println("Successfully logged in");
            setLoggedIn(true);
        } else {
            System.out.println("Failed to login.");
            loginMessage.setText("Incorrect username or password");
        }
    }   

}