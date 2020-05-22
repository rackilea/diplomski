public class IntFilter extends DocumentFilter {

    private ValidationListener validationListener;

    public void setValidationListener(ValidationListener validationListener) {
        this.validationListener = validationListener;
    }

    public ValidationListener getValidationListener() {
        return validationListener;
    }

    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {

        boolean validationFailed = false;
        StringBuilder buffer = new StringBuilder(text.length());
        for (int index = 0; index < text.length(); index++) {
            if (Character.isDigit(text.charAt(index))) {
                buffer.append(text.charAt(index));
            } else {
                validationFailed = true;
            }
        }
        super.insertString(fb, offset, buffer.toString(), attr);
        ValidationListener listener = getValidationListener();
        if (listener != null) {
            if (validationFailed) {
                listener.validationFailed(this);
            } else {
                listener.validationPassed(this);
            }
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String string, AttributeSet attr) throws BadLocationException {
        if (length > 0) {
            fb.remove(offset, length);
        }
        insertString(fb, offset, string, attr);
    }
}