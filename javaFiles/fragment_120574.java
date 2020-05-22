@FXML
  private void handleButtonAction(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
    JavaFXApplication12.currentStage.setScene(new Scene(root));
    Platform.runLater(new Runnable() {
        @Override
        public void run() {
           JavaFXApplication12.currentStage.setFullScreen(false);
           JavaFXApplication12.currentStage.setFullScreen(true);
       }
    });
  }