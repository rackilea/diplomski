private Scene mainScene;

@Override
public void start(Stage stage) {
    Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();

    Label label = new Label("Main Scene");        
    StackPane root = new StackPane(label);
    mainScene = new Scene(root, visualBounds.getWidth(), visualBounds.getHeight());

    stage.setScene(mainScene);
    stage.show();

    label.setOnMouseClicked(e->{
        Label labelSettings = new Label("Settings Scene. Click to go back");
        StackPane rootSettings = new StackPane(labelSettings);
        Scene settingsScene = new Scene(rootSettings, visualBounds.getWidth(), visualBounds.getHeight());
        stage.setScene(settingsScene);
        labelSettings.setOnMouseClicked(t->stage.setScene(mainScene));
    });
}