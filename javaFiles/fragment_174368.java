public class MainController {

    @FXML
    private ToggleButton manualModeBtn;
    @FXML
    private ToggleButton automaticModeBtn;


    public void initialize() {
        manualModeBtn.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> automaticModeBtn.setSelected(! isNowSelected));
        automaticModeBtn.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> manualModeBtn.setSelected(! isNowSelected));

    }
}