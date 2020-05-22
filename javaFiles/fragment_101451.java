public class PersianNumberDocumentFilter extends DocumentFilter {
    private static final String REPLACE_CHARS = "0123456789.";

    @Override
    public void insertString(FilterBypass fb, int offset, String text,
                             AttributeSet attr) throws BadLocationException {
        if (text != null && !text.isEmpty() && REPLACE_CHARS.contains(text)) {
            text = doSwap(text);
        }
        super.insertString(fb, offset, text, attr);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
                        AttributeSet attrs) throws BadLocationException {
        if (text != null && !text.isEmpty() && REPLACE_CHARS.contains(text)) {
            text = doSwap(text);
        }
        super.replace(fb, offset, length, text, attrs);
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length)
            throws BadLocationException {
        super.remove(fb, offset, length);
    }

    public String doSwap(String text) {
        InputContext context = InputContext.getInstance();
        String windowsKeyboardSelected = context.getLocale().toString();
        if (!windowsKeyboardSelected.contains("fa") && !windowsKeyboardSelected.contains("ar")) {
            return text;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (REPLACE_CHARS.contains(String.valueOf(c))) {
                if (c == '.') {
                    c = ',';
                } else {
                    c = (char) ('\u06F0' - '0' + c);
                    //c = (char) ('\u0660' - '0' + c); Arabic Number Digits
                }
            }
            sb.append(c);
        }

        return sb.toString();
    }
}