public class UnitFormController { // your actual class name may differ....

    private final BooleanProperty saved = new SimpleBooleanProperty();

    public BooleanProperty savedProperty() {
        return saved ;
    }
    public final boolean isSaved() {
        return savedProperty().get();
    }
    public final void setSaved(boolean saved) {
        savedProperty().set(saved);
    }

    // other code as you already have...

    @FXML
    private void saveUnit() {
        setSaved(true);
    }

    // ...
}