public class FirstController {

  // ...

    @FXML
    private void openStage2Action(ActionEvent event) throws IOException {
        Stage2 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Second.fxml"));
        Object root = fxmlLoader.load();
        Scene scene = new Scene((Parent) root);
        Stage2.setScene(scene);
        SecondController secondController = (SecondController)fxmlLoader.getController();
        secondController.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> obs, String oldValue, String newValue) {
                textArea1.appendText(newValue);
            }
        });
        Stage2.show();  
    }
}