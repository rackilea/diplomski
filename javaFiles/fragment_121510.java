public class MainController extends Controller { 
    @FXML private Window dialog;
    @FXML private DialogController dialogController;

    public void initialize() {
        dialogController.selectedPersonProperty().addListener((obs, oldPerson, newPerson) -> {
            // ... whatever you need to do here with new data when OK is pressed in dialog...
        });
    }
}