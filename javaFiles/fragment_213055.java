private final ReadOnlyBooleanWrapper hasFocus = new ReadOnlyBooleanWrapper(this, "hasFocus");
hasFocus.bind(
     hourField.focusedProperty()
    .or(minuteField.focusedProperty())
    .or(datePicker.focusedProperty())
    .or(showTimePickerButton.focusedProperty()));

// ...
public ReadOnlyBooleanProperty hasFocusProperty() {
    return hasFocus.getReadOnlyProperty();
}