public void start(Stage stage) {
    FXMLLoader loader = MyOwnLoader.getFxmlLoader();
    MyController controller = loader.getController();
    Parameters params = getParameters();
    log.error(params.getRaw().toString());
    //Also return the filename  : log.info(params.getUnnamed().toString());
    //Don't return the filename : log.info(params.getNamed().toString());
}