public class PromptButtonCell<T> extends ListCell<T> {

    private final StringProperty promptText = new SimpleStringProperty();

    public PromptButtonCell(String promptText) {
        this.promptText.addListener((obs, oldText, newText) -> {
            if (isEmpty() || getItem() == null) {
                setText(newText);
            }
        });
        setPromptText(promptText);
    }

    public StringProperty promptTextProperty() {
        return promptText ;
    }

    public final String getPromptText() {
        return promptTextProperty().get();
    }

    public final void setPromptText(String promptText) {
        promptTextProperty().set(promptText);
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(getPromptText());
        } else {
            setText(item);
        }
    }
}