public class SolverManager {

    private final Scene scene;
    private FXMLMainController mainController;
//    private FXMLLoadLogController loadLogController;
//    private FXMLEditLogController editLogController;

    public SolverManager(Scene scene) {
        this.scene = scene;
    }

    public void showMainView() throws IOException {
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("FXMLMain.fxml"));
        scene.setRoot((Parent) mainLoader.load());
        mainController = mainLoader.<FXMLMainController>getController();

//        FXMLLoader loadLoader = new FXMLLoader(getClass().getResource("FXMLLoadLog.fxml"));
//        loadLoader.load();
//        loadLogController = loadLoader.<FXMLLoadLogController>getController();
//        FXMLLoader editLoader = new FXMLLoader(getClass().getResource("FXMLEditLog.fxml"));
//        editLoader.load();
//        editLogController = editLoader.<FXMLEditLogController>getController();
    }

    public void refreshI18nResources() {
        mainController.chargeI18nValues();
//        loadLogController.chargeI18nValues();
//        editLogController.chargeI18nValues();
    }
}