private static final int MAX_VISIBLE_LINES = 12;

private final Deque<String> lines = new LinkedList<>();

void appendLine(String line,
                JTextArea textArea) {

    lines.addLast(line);
    if (lines.size() > MAX_VISIBLE_LINES) {
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