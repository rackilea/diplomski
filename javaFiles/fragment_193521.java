public class LoginApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        LoginView loginView = new LoginView(primaryStage);
        // ...
        loginView.show();
    }
}