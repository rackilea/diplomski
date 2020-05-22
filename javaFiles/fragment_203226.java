@FXML
private void click(MouseEvent event) {
    // retrieve the node the event occured on
    Button btn = (Button) event.getSource();

    // retrieve Label associated with event source
    Label label = (Label) btn.getUserData();

    // now we've got all info we need without using any field of the controller
    System.out.println(label.getText());
}