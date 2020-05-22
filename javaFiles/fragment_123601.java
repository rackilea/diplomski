// controller for individual content
public class ContentController {
    private BooleanProperty menuShowingProperty ;
    public void setMenuShowingProperty(BooleanProperty menuShowingProperty) {
        this.menuShowingProperty = menuShowingProperty ;
    }

    public void initialize() {
        // ...
    }

    // handler method for button that shows menu:
    @FXML
    private void showMenu() {
        menuShowingProperty.set(true);
    }
}