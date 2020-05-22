btnl2.setOnAction(new EventHandler<ActionEvent>() {
 @Override
 public void handle(ActionEvent e) {
     Stage usrpagestage = new Stage();
     usrpagestage.setScene(new Scene(new UserPage()));
     ((Stage)btnl2.getScene().getWindow()).close();
     usrpagestage.show();
 }
 });