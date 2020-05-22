final TextField addressBar = new TextField();
addressBar.setOnAction(new EventHandler<ActionEvent>() {
  public void handle(ActionEvent event) {
    myWebEngine.load(addressBar.getText());
  }
});