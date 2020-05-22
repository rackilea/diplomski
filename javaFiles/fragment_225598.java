FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/dictionary.fxml"));
    loader.setControllerFactory(injector::getInstance);
    try {
        Parent root = loader.load();
        scene = new Scene(root);
    } catch (IOException e) {
        throw new IllegalStateException(e);
    }