@FXML
public void copyToClipboardRaw() {
    copyToClipboard(rawCode);
}

@FXML
public void copyToClipboardHTML() {
    copyToClipboard(codeForHTML);
}

private void copyToClipboard(TextField source) {
    if(code == null || code.isEmpty()) {
        nothingToCopyAlert();
    } else {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(source.getText());
        clipboard.setContent(content);
    }
}