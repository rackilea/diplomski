public class ChildController {

    private final BooleanProperty stuffShouldBeDisabled = new SimpleBooleanProperty();

    public BooleanProperty stuffShouldBeDisabledProperty() {
        return stuffShouldBeDisabled ;
    }

    public final boolean getStuffShouldBeDisabled() {
        return stuffShouldBeDisabledProperty().get();
    }

    @FXML
    private void handleButtonClick(ActionEvent event) {
        stuffShouldBeDisabled.set( ! stufShouldBeDisabled.get() );
    }

    // ...
}