FXMLLoader loader = 
    new FXMLLoader(getClass().getResource("/projectname/unit/UnitForm.fxml"));
Pane pane = (Pane) loader.load();
UnitFormController controller = loader.getController();
controller.savedProperty().addListener((obs, wasSaved, isNowSaved) -> {
    if (isNowSaved) {
        UnitBorderPane.setLeft(null);
    }
});
UnitBorderPane.setLeft(pane);