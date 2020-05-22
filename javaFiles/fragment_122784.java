// in MainApp.java
public void showAlert(String myTitle, Node myContent) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle(myTitle);
    alert.setHeaderText(null);
    alert.getDialogPane.setContent(myContent);
    alert.showAndWait();
}

// or your custom stage
public void showAlert(String myTitle, Node myContent) {
    Stage dialogStage = new Stage();
    dialogStage.initModality(Modality.WINDOW_MODAL);
    dialogStage.setScene(new Scene(new VBox(new Label(myTitle), myContent));
    dialogStage.show();
}