btnl2.setOnAction(new EventHandler<ActionEvent>() {
 @Override
 public void handle(ActionEvent e) {
  ((Stage)btnl2.getScene().getWindow()).setScene(new Scene(new UserPage()));
 }
 });