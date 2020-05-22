public class ControllerA {
    @FXML
    private TextField usernameTextField;

    @FXML
    private Button loginButton;

    private Stage stage;

    @FXML
    private void initialize() {
        loginButton.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("scene_2.fxml"));
                Parent parent = loader.load();

                ControllerB controllerB = loader.getController();
                controllerB.setUser(new User(usernameTextField.getText()));

                stage.setScene(new Scene(parent));

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

public class ControllerB {

    private User user;

    @FXML
    private Label wellcomeLabel;

    @FXML
    private void initialize() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        wellcomeLabel.setText("Wellcome " + user.getName());
    }
}

public class MainStage extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene_1.fxml"));
        Parent parent = loader.load();

        ControllerA controllerA = loader.getController();
        controllerA.setStage(primaryStage);

        primaryStage.setTitle("Demo");
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}