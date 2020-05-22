private void checkLength() {
    Editable editable = mNumber.getText();
    int charCount = editable.length();
    if (charCount > 2) {
        editable.delete(charCount - 1, charCount);
    }