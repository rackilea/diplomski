public static void loadContent(String fxmlFile){
    try {
        FXMLLoader loader = new FXMLLoader(ContentNavigator.class.getResource(fxmlFile));
        AnchorPane pane = loader.<AnchorPane>load();
        Object controller = loader.getController();
        if (controller instanceof ContentController) {
            ContentController contentController = (ContentController) controller ;
            contentController.setMenuShowingProperty(mainController.menuShowingProperty());
        }
        mainController.setContent(pane);
    } catch (IOException ex) {
        Logger.getLogger(ContentNavigator.class.getName()).log(Level.SEVERE, null, ex);
    }
}