FXMLLoader fxmlLoader = new FXMLLoader();
try {
    fxmlLoader.load(getClass().getResource("Home.fxml").openStream());
    MyControllerClass controller = fxmlLoader.getController();
    // Or use this to find your label
    Label myLabel = (Label) fxmlLoader.getNamespace().get("lblName");
} catch (IOException e) {
    e.printStackTrace();
}