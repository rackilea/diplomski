JTextField tf = new JTextField();
AbstractDocument d = (AbstractDocument) tf.getDocument();
d.setDocumentFilter(new DocumentFilter(){
    int max = 1;

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        int documentLength = fb.getDocument().getLength(); 
            if (documentLength - length + text.length() <= max)
        super.replace(fb, offset, length, text.toUpperCase(), attrs);
    }
});