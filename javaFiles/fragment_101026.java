public void loadAndLink(Object controller, String viewPath) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource(viewPath));
    loader.setController(controller);
    try {
        loader.load();
    } catch (IOException e) {
        // ...
    }
}