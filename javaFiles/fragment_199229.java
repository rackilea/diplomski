private static final String TEXT_SUBMIT = "text-submit";
private static final String INSERT_BREAK = "insert-break";
...
private void initialize() {
    InputMap input = inputTextArea.getInputMap();
    KeyStroke enter = KeyStroke.getKeyStroke("ENTER");
    KeyStroke shiftEnter = KeyStroke.getKeyStroke("shift ENTER");
    input.put(shiftEnter, INSERT_BREAK);  // input.get(enter)) = "insert-break"
    input.put(enter, TEXT_SUBMIT);

    ActionMap actions = inputTextArea.getActionMap();
    actions.put(TEXT_SUBMIT, new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            submitText();
        }
    });
}
...
private void submitText() {
    // TODO
}