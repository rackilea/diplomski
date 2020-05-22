private final Deque<String> lines = new LinkedList<>();

void appendLine(String line,
                JTextArea textArea) {

    FontMetrics metrics = textArea.getFontMetrics(textArea.getFont());

    JViewport viewport = (JViewport) textArea.getParent();
    int visibleLineCount = viewport.getExtentSize().height / metrics.getHeight();

    lines.addLast(line);
    while (lines.size() > visibleLineCount) {
        lines.removeFirst();
    }

    String text = String.join("\n", lines);
    textArea.setText(text);

    textArea.setCaretPosition(text.length());
    try {
        textArea.scrollRectToVisible(
            textArea.modelToView(text.length()));
    } catch (BadLocationException e) {
        throw new RuntimeException(e);
    }
}