public class UppercaseDocumentFilter extends DocumentFilter {

    private boolean isEmail;

    public UppercaseDocumentFilter(boolean isEmail) {
        this.isEmail = isEmail; 
    }

    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        fb.insertString(offset, isEmail? text: text.toUpperCase(), attr);
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        fb.replace(offset, length, isEmail? text: text.toUpperCase(), attrs);
    }
}