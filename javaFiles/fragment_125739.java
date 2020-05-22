static class DocumentSizeAndUppercaseFilter extends DocumentFilter {

    private final int max;

    public DocumentSizeAndUppercaseFilter(int max) {
        this.max = max;
    }

    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset,
                             String text, AttributeSet attr) 
            throws BadLocationException {
        if (fb.getDocument().getLength() + text.length() < max)
            super.insertString(fb, offset, text.toUpperCase(), attr);
        else 
            showError();
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset,
                        int length, String text, AttributeSet attrs)
            throws BadLocationException {
        int documentLength = fb.getDocument().getLength();
        if (documentLength - length + text.length() < max)
            super.replace(fb, offset, length, text.toUpperCase(), attrs);
        else 
            showError();
    }

    private void showError() {
        JOptionPane.showMessageDialog(null, "Too many characters entered");
    }
}