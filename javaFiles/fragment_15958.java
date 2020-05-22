public void start(Stage primaryStage) {

    try {
        stage = primaryStage;

        gotohome();

        primaryStage.show();
    } catch (Exception ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void gotohome() {
    try {
        FXMLController home = (FXMLController) replaceSceneContent("Homepage.fxml");
        home.setApp(this);
    } catch (Exception ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void gotoproductwise() {
    try {
        SampleController product_wise = (SampleController) replaceSceneContent("/product_wise/product_wise.fxml");
        product_wise.setApp(this);
    } catch (Exception ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
}


private Initializable replaceSceneContent(String fxml) throws Exception {
    FXMLLoader loader = new FXMLLoader();
    InputStream in = Main.class.getResourceAsStream(fxml);
    loader.setBuilderFactory(new JavaFXBuilderFactory());
    loader.setLocation(Main.class.getResource(fxml));
    AnchorPane page;
    try {
        page = (AnchorPane) loader.load(in);
    } finally {
        in.close();
    }

    // Store the stage width and height in case the user has resized the window
    double stageWidth = stage.getWidth();
    if (!Double.isNaN(stageWidth)) {
        stageWidth -= (stage.getWidth() - stage.getScene().getWidth());
    }

    double stageHeight = stage.getHeight();
    if (!Double.isNaN(stageHeight)) {
        stageHeight -= (stage.getHeight() - stage.getScene().getHeight());
    }

    Scene scene = new Scene(page);
    if (!Double.isNaN(stageWidth)) {
        page.setPrefWidth(stageWidth);
    }
    if (!Double.isNaN(stageHeight)) {
        page.setPrefHeight(stageHeight);
    }

   // stage.setOpacity(1);
    stage.setScene(scene);
    stage.sizeToScene();
    return (Initializable) loader.getController();
}