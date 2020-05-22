@FXML
private PropertySheet sheet;

public void initialize() {
    sheet.getItems().setAll(BeanPropertyUtils.getProperties(new BeanObj()));
    sheet.setMode(PropertySheet.Mode.NAME);
}