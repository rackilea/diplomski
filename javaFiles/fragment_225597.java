FXMLLoader loader = new FXMLLoader();
    try {
        Parent root = loader.load(getClass().getResourceAsStream("/dictionary.fxml"));
        loader.setControllerFactory(injector::getInstance);
        scene = new Scene(root);
    } catch (IOException e) {
        throw new IllegalStateException(e);
    }