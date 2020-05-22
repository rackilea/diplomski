textArea.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            try {
                textArea.setCaretPosition(
                   textArea.getLineStartOffset(textArea.getLineCount() - 1)
                );
            } catch (BadLocationException e1) {
                e1.printStackTrace();
            }
        }
    }