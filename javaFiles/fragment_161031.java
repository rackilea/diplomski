btn.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // OR, if you define btn as @FXML private Button btn.
        Stage stage = (Stage) btn.getScene().getWindow();
        // these two of them return the same stage
        stage.setWidth(new_val);
        stage.setHeight(new_val);
    }
});