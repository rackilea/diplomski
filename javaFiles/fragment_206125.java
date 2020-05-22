private List<TextField> textInputs;
private List<ToggleGroup> toggleGroups;

@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
    ...
    textInputs = Arrays.asList(value1, value2, value3, mul1, mul2, mul3, advance, coolie, market, name);

    // after initializing the ToggleGroups
    toggleGroups = Arrays.asList(toggleGroup, toggleGroup2);
}

...

public boolean isTrue() { // choose a better name for this
    boolean valid = (date.getValue() != null);

    if (valid) {
        for (TextField tf : textInputs) {
            if (tf.getText().trim().isEmpty()) {
                valid = false;
                break;
            }
        }
        if (valid) {
            for (ToggleGroup tg : toggleGroups) {
                if (tg.getSelectedToggle() == null) {
                    valid = false;
                    break;
                }
            }
        }
    }
    if (!valid) {
        // show alert here...
    }
    return valid;
}