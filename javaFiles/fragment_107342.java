@Override
public void start(Stage stage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml")); // Use loader instance
    Parent root = loader.load();
    FXMLDocumentController controller = loader.getController(); // Now you have controller refference here
    //add your listener, feel free to use your controller inside listener implementation
}