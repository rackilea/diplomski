public void append(String str) {
    Document doc = getDocument();
    if (doc != null) {
        try {
            doc.insertString(doc.getLength(), str, null);
        } catch (BadLocationException e) {
        }
    }
}