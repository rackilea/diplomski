public class Mediator {
    private static Mediator INSTANCE;

    private Stage stage;
    private User user;

    public static Mediator getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Mediator();
        }
        return INSTANCE;
    }

    private Mediator() {
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

public class MainStage extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Mediator.getInstance().setStage(primaryStage);

        Parent parent = FXMLLoader.load(getClass().getResource("scene_1.fxml"));

        primaryStage.setTitle("Demo");
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

public class ControllerA {
    @FXML
    private TextField usernameTextField;

    @FXML
    private Button loginButton;

    @FXML
    private void initialize() {
        loginButton.setOnAction(event -> {
            try {
                Mediator.getInstance().setUser(new User(usernameTextField.getText()));
                Parent parent = FXMLLoader.load(getClass().getResource("scene_2.fxml"));

                Stage stage = Mediator.getInstance().getStage();
                stage.setScene(new Scene(parent));

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

public class ControllerB {

    @FXML
    private Label wellcomeLabel;

    @FXML
    private void initialize() {
        User user = Mediator.getInstance().getUser();
        wellcomeLabel.setText("Wellcome " + user.getName());
    }

}