public class PlayerInfo {

    @FXML
    private Parent root1;

    public static PlayerInfo create() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML_Files/PlayerInfo.fxml"));
        fxmlLoader.load();
        return fxmlLoader.getController();
    }

    public PersonData Show() {
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("Enter Player Information");
        stage.setScene(new Scene(root1));
        stage.showAndWait();
        return new PersonData(txtName.getText(), colorColorPicker.getValue(), chkComputer.isSelected());
    }
    ...
}