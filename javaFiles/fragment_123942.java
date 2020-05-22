@FXML
private void handleClicks(ActionEvent event) {
    Map<Object, Object> properties = ((Node) event.getSource()).getProperties();
    System.out.println("year: "+properties.get("year"));
    System.out.println("month: "+properties.get("month"));
}