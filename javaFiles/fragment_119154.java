public class InfoTableController {

    ...

    @FXML
    public void initialize() {
        ...
//        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            final String id = newValue.getId();
//            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/InfoDisplay.fxml"));
//            try {
//                final Parent parent = loader.load();
//            } catch (final IOException e1) {
//                e1.printStackTrace();
//            }
//            final InfoDisplayController idc = (InfoDisplayController) loader.getController();
//            idc.displayDocument(id);
//        });
        ...
    }

    public ObjectProperty<Info> selectedItemProperty() {
        return table.getSelectionModel().selectedItemProperty();
    }
}