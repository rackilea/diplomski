private Object createControllerForType(Class<?> type) {
    return this.applicationContext.getBean(type);
}

private FXMLLoader loadSynchronously(URL resource) throws IllegalStateException {

    FXMLLoader loader = new FXMLLoader(resource);
    loader.setControllerFactory(this::createControllerForType);

    try {
        loader.load();
    } catch (IOException ex) {
        throw new IllegalStateException("Cannot load Resource!", ex);
    }

    return loader;
}

private void initializeFxmlLoader() {
    this.fxmlLoader = loadSynchronously(resource);
    this.presenterProperty.set(this.fxmlLoader.getController());
}

public void setResource (String resource) {
    this.resource = getClass().getResource(resource);
}

public Parent getView() {

    initializeFxmlLoader();

    Parent parent = fxmlLoader.getRoot();
    return parent;
}