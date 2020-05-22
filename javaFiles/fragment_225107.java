public void showFilmeOverview() {       
    try {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((MainApp.class.getResource("resources/FilmeOverview.fxml")));
        //----------------
        AnchorPane filmeOverview = (AnchorPane) loader.load();
        FilmeOverviewController controller = loader.getController();
        controller.setMainApp(this);
        //----------------
        rootLayout.setCenter(filmeOverview);
    }catch (IOException e){

        e.printStackTrace();
    }

}