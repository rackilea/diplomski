Button b = new Button();
b.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        Stage stage = new Stage();
        //Fill stage with content
        stage.show();
    }
});