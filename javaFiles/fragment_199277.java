public class MainController {

    @FXML
    private ChildController childController ; // injected via <fx:include fx:id="child" ... />

    @FXML
    private Tab someTab ;

    public void initialize() {
        childController.stuffShouldBeDisabledProperty().addListener((obs, wasDisabled, isNowDisabled) -> {
            someTab.setDisable(isNowDisabled);
        }
    }

    // ...
}