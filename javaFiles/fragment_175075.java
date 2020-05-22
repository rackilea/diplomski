private final BooleanProperty editable = new SimpleBooleanProperty();

public boolean isEditable() {
    return editable.get();
}

public void setEditable(boolean value) {
    editable.set(value);
}

public final BooleanProperty editableProperty() {
    return editable;
}

private final StringProperty textFromTextBox = new SimpleStringProperty();

public String getTextFromTextBox() {
    return textFromTextBox.get();
}

public void setTextFromTextBox(String value) {
    textFromTextBox.set(value);
}

public final StringProperty textFromTextBoxProperty() {
    return textFromTextBox;
}

private final StringProperty labelText = new SimpleStringProperty();

public String getLabelText() {
    return labelText.get();
}

public void setLabelText(String value) {
    labelText.set(value);
}

public final StringProperty labelTextProperty() {
    return labelText;
}