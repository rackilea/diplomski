@FXML
public void initialize() {
    createAccountButton.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            // TODO Auto-generated method stub
            createAccountAction(event);
        }
    });
}