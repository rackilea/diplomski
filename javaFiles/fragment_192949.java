@Override
public void initialize(URL arg0, ResourceBundle arg1) {
    //Load Splash screen
    if (!MainClass.isSplashLoaded)
        loadSplashScreen();

    //load drawer content
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("drawerContent.fxml"));
        VBox box = loader.load();

        DrawerContentController drawerContentController = loader.getController();
        progressBar.progressProperty().bind(drawerContentController.progressProperty());

        drawer.setSidePane(box);

        // ... existing code
    }

    // ...
}