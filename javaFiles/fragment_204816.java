String copiedText = "";

if ("user presses copy button") {
    if (textArea.getSelectedText() != null) {
        copiedText = textArea.getSelectedText();
    }
}

if ("user presses paste button") {
    textArea.insert(copiedText, textArea.getCaretPosition());
}