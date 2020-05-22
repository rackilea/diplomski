public class BackupUI extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        final HBox hBox = new HBox();
        hBox.setSpacing(5);

        final TextField locationTextField = new TextField("F:\\Backup.sql");
        Button saveButton = new Button("Save");

        saveButton.setOnAction(event -> save(locationTextField.getText()));

        hBox.getChildren().add(locationTextField);
        hBox.getChildren().add(saveButton);
        primaryStage.setScene(new Scene(hBox));

        primaryStage.show();
    }

    private void save(String fileName) {
        System.out.println(String.format("Backup %s!", fileName));
    }
}