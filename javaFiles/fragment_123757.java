@Override
public void start(Stage primaryStage) {
    Button btn = new Button("Show alert");
    btn.setOnAction((ActionEvent event) -> {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.getDialogPane().setStyle("-fx-border-color: black;");
        alert.initModality(Modality.APPLICATION_MODAL);

        alert.initStyle(StageStyle.UNDECORATED);

        alert.initOwner(primaryStage);
        alert.setHeaderText("Quit Game");
        alert.setContentText("Are you sure?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(null) == ButtonType.OK) {
            Platform.exit();
        }
    });

    StackPane root = new StackPane();
    root.getChildren().add(btn);

    Scene scene = new Scene(root, 600, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
}