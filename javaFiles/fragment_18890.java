public class MainController {

    @FXML
    private Parent top ;
    @FXML
    private Parent clavier ;
    @FXML
    private Parent bottom ;

    @FXML
    private TopController topController ;
    @FXML
    private ClavierController clavierController ;
    @FXML
    private BottomController bottomController ;

    private final Model model ;

    public MainController(Model model) {
        this.model = model ;
    }

    @FXML
    public void initialize() {
        topController.setModel(model);
        clavierController.setModel(model);
        bottomController.setModel(model);
    }

    // ...
}