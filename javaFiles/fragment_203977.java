public void setText(String t) {
    try {
        Document doc = getDocument();
        if (doc instanceof AbstractDocument) {
            ((AbstractDocument)doc).replace(0, doc.getLength(), t,null);
        }
        else {
            doc.remove(0, doc.getLength());
            doc.insertString(0, t, null);
        }
    } catch (BadLocationException e) {
    UIManager.getLookAndFeel().provideErrorFeedback(JTextComponent.this);
    }
}