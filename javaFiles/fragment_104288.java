Action moveToSelectionStart = new AbstractAction("moveCaret") {

        @Override
        public void actionPerformed(ActionEvent e) {
            int selectionStart = textComponent.getSelectionStart();
            int selectionEnd = textComponent.getSelectionEnd();
            if (selectionStart != selectionEnd) {
                textComponent.setCaretPosition(selectionEnd);
                textComponent.moveCaretPosition(selectionStart);
            }
        }

        public boolean isEnabled() {
            return textComponent.getSelectedText() != null;
        }
    };
    Object actionMapKey = "caret-to-start";
    textComponent.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), actionMapKey);
    textComponent.getActionMap().put(actionMapKey, moveToSelectionStart);