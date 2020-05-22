URL viewLocation = getClass().getResource("/importView.fxml");
FXMLLoader loader = new FXMLLoader(viewLocation);

try {
    loader.load();

    ImportController importController = loader.getController();
    importController.setMainController(this);
} catch (IOException exception) {
    exception.printStackTrace();
}