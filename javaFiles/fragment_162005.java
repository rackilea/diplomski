public class MainController {
    private final Model model ;

    @FXML
    private TableView<TableMessage> messageTable ;

    public MainController(Model model) {
        this.model = model ;
    }

    public void initialize() {
        messageTable.setItems(model.getMessages());
        // ...
    }
}