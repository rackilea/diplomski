@Override
public void start(Stage primaryStage) {
    Button btn = new Button("Hide me 5 sec");

    // prevent automatic exit of application when last window is closed
    Platform.setImplicitExit(false);

    StackPane root = new StackPane();
    root.getChildren().add(btn);

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);

    // timer should be a daemon (-> not prevent jvm shutdown)
    Timer timer = new Timer(true);

    btn.setOnAction((ActionEvent event) -> {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // make window reappear (needs to happen on the application thread)
                Platform.runLater(primaryStage::show);
            }
        }, 5000l);

        // hide window
        primaryStage.close();
    });

    // allow exiting the application by clicking the X
    primaryStage.setOnCloseRequest(evt -> Platform.exit());

    primaryStage.show();
}