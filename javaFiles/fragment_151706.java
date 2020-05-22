private void addValueFromEditText(EditText yourEditText) {
    try {
        edTotal += Integer.valueOf(yourEditText.getText().toString());
    } catch (NumberFormatException exception) {
        Toast.makeText(context, yourEditText + " has non Integer value", Toast.LENGTH_SHORT).show();
    }
}

private void multiplyByValueFromEditText(EditText yourEditText) {
    try {
        edTotal *= Integer.valueOf(yourEditText.getText().toString());
    } catch (NumberFormatException exception) {
        Toast.makeText(context, yourEditText + " has non Integer value", Toast.LENGTH_SHORT).show();
    }
}

private void divideByValueFromEditText(EditText yourEditText) {
    try {
        edTotal /= Integer.valueOf(yourEditText.getText().toString());
    } catch (NumberFormatException exception) {
        Toast.makeText(context, yourEditText + " has non Integer value", Toast.LENGTH_SHORT).show();
    }

private void sumAllEditTexts() {
    addValueFromEditText(ed1);
    addValueFromEditText(ed2);
    addValueFromEditText(ed3);
    addValueFromEditText(ed4);
    addValueFromEditText(ed5);
    addValueFromEditText(ed6);
}