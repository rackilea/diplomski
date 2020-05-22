float inputValue = 1.0f; // some default value, in case the user input is bad.
try {
    inputValue = Float.parseFloat(text9.getText().toString());
} catch (NumberFormatException e) {
    // possibly display a red flag next to the field
}