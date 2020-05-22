FXMLLoader loader = new FXMLLoader(fxmlUrl);
myNode = loader.load();
Controller controller = loader.getController();
controller.addSelectedIndexListener((observable, oldValue, newValue) -> {
    ...
});