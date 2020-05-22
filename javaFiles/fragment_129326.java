private Scene mainScene;

@Override
public void start(Stage stage) {
    Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();

    Label label = new Label("Main Stage");        
    StackPane root = new StackPane(label);
    root.setStyle("-fx-background-color: aquamarine;");
    mainScene = new Scene(root, visualBounds.getWidth(), visualBounds.getHeight());

    stage.setScene(mainScene);
    stage.setTitle("Main Stage");
    stage.show();

    label.setOnMouseClicked(e->{
        Label labelSettings = new Label("Settings Stage. Click to go back");
        StackPane rootSettings = new StackPane(labelSettings);
        rootSettings.setStyle("-fx-background-color: burlywood;");
        Scene settingsScene = new Scene(rootSettings, visualBounds.getWidth(), visualBounds.getHeight());
        Stage stage2 = new Stage();
        stage2.setScene(settingsScene);
        stage2.show();
        labelSettings.setOnMouseClicked(t->stage2.hide());
    });
}