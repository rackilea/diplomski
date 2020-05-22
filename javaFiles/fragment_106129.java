public ShortcutButton(String text, ActionListener actionListener, KeyStroke... keyStrokes) {
    super(text);
    addActionListener(actionListener);
    addShortcuts(keyStrokes);
}
public ShortcutButton(String text, ActionListener actionListener, String... keyStrokes) {
    super(text);
    addActionListener(actionListener);
    addShortcuts(keyStrokes);
}