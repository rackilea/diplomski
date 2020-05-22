public void create_ConfigStage() {
    stage = new Stage();
    FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("windows/configureTemplates.fxml"));

    // Tell the FXMLLoader to use this object as the controller.
    // Note that if the fxml file has a fx:controller attribute, 
    // loading it will fail with an IllegalStateException:

    loader.setController(this);


    AnchorPane root = null;

    try {
        // Since we set this object as the controller, loading will 
        // initialize all the @FXML fields defined in this instance, and will
        // invoke initialize() on this instance:
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println(testVal); // This should show the value updated in initialize()
    System.out.println(words.size()); // This should give the number loaded by FileUtil.readMacroFile(...)
}