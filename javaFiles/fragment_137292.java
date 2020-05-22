public class TrackableTextField extends javafx.scene.control.TextField {

    private StringProperty originalText = new ReadOnlyStringWrapper(this, "originalText");
    public final String getOriginalText() { return originalText.get(); }
    public final void setOriginalText(String value) { 
        originalText.set(value);
        setText(value);
    }
    public final StringProperty originalTextProperty() { return originalText; }

    private final ReadOnlyBooleanWrapper dirty = new ReadOnlyBooleanWrapper(this, "dirty", false);
    public final boolean isDirty() { return dirty.get(); }
    public final ReadOnlyBooleanProperty dirtyProperty() { return dirty.getReadOnlyProperty(); }

    public TrackableTextField() {
        init();
    }

    public TrackableTextField(String text) {
        init();
        setOriginalText(text);
    }

    private void init() {
        textProperty().addListener( e -> {
            dirty.set(!Objects.equals(getOriginalText(), getText()));
        } );
    }

    public void rollback() {
        setText(getOriginalText());
    }

    public void commit() {
        setOriginalText(getText());
    }
}