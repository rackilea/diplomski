public void replace(FilterBypass fb, int offset, int length, String text,
                AttributeSet attrs) throws
                BadLocationException {
    if (isNumeric(text)) {

        System.out.println(offset + "; " + length + "; " + text);

        if (this.length > 0 && 
            fb.getDocument().getLength() + text.length() - length > this.length) {
            return;
        }
        super.replace(fb, offset, length, text, attrs);
    }
}