public class MainController implements Initializable {   

    /***CONTROLS***/
    @FXML private VBox   _eggsContainer;
    @FXML private Button _btnAddEgg;
    @FXML private Button _btnPrintEggs;
    @FXML private Button _btnBreakEggs;

    private final List<EggController> eggs = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        _btnAddEgg.setOnAction(e -> {
            doAddEgg();
        });
        _btnPrintEggs.setOnAction(e -> {
            doPrintAllEggs();
        });
        _btnBreakEggs.setOnAction(e -> {
            doBreakAllEggs();
        });
    }

    // Add an egg to _eggsContainer
    private void doAddEgg() {
        HBox eggControl = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EggView.fxml"));
            eggControl = loader.load();
            EggController controller = loader.getController();
            eggs.add(controller);
        } catch (IOException e) {
            e.printStackTrace();
        }
        _eggsContainer.getChildren().add(eggControl);
    }

    private void doPrintAllEggs() {
        // prints ID and Color of each egg in _eggsContainer
        for (EggController controller : eggs) {
            System.out.println(controller.getEggId() + " : " + controller.getEggColor());
        }
    }

    private void doBreakAllEggs() {
        eggs.forEach(EggController::doBreakEgg);
    }
}