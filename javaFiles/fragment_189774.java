@Override
public void start(Stage primaryStage) {
    Button btn = new Button();
    btn.setText("Show Login Dialog");
    btn.setOnAction(mevent -> {

        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Mars Simulation Project");
        dialog.setHeaderText("Log in");
        dialog.setContentText("Enter your username and password : ");
        dialog.initModality(Modality.NONE);
        // Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField tfPlayer = new TextField();
        tfPlayer.setPromptText("e.g. m03j");
        PasswordField tfPassword = new PasswordField();
        tfPassword.setPromptText("xxxx");

        Button defaultPWB = new Button("Use Default");
        Button guestB = new Button("As Guest");
        defaultPWB.setOnAction(event -> {
            tfPassword.setText("msp0");
        } );

        guestB.setOnAction(event -> {
            tfPlayer.setText("Guest_");
            tfPassword.setText("msp0");
        } );

        grid.add(new Label("Player Name :"), 0, 0);
        grid.add(tfPlayer, 1, 0);
        grid.add(guestB, 2, 0);
        grid.add(new Label("Password :"), 0, 1);
        grid.add(tfPassword, 1, 1);
        grid.add(defaultPWB, 2, 1);

        // Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

        // Do some validation (using the Java 8 lambda syntax).
        tfPlayer.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        } );

        dialog.getDialogPane().setContent(grid);

        // Request focus on the player name field by default.
        Platform.runLater(() -> tfPlayer.requestFocus());

        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.show();            

        loginButton.addEventFilter(EventType.ROOT, 
            e->{
                if(e.getEventType().equals(ActionEvent.ACTION)){
                    e.consume();
                    // (hardcoded) Login Validation
                    boolean isSuccessful = false;
                    if (isSuccessful) {
                        dialog.close();
                    }
                    else {
                        ShakeTransition anim = new ShakeTransition(dialog.getDialogPane(), t->dialog.close());
                        anim.playFromStart();
                    }
                }
            });
    });

    StackPane root = new StackPane();
    root.getChildren().add(btn);

    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle("Shaky Login Dialog");
    primaryStage.setScene(scene);
    primaryStage.show();
}