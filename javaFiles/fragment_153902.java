private UIController thisController;

@Override
public void initialize(URL url, ResourceBundle rb) {
    thisController = this;
}

@FXML
private void actionLockdown(ActionEvent event) {
    button.lockdown(thisController);