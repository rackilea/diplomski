public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a)
        throws BadLocationException {

    String text = fb.getDocument().getText(0, fb.getDocument().getLength());
    text += str;
    if ((fb.getDocument().getLength() + str.length()
            - length) <= maxCharacters && text.matches("^[0-9]+[.]?[0-9]{0,1}$")) {
        super.replace(fb, offs, length, str, a);
    } else {
        Toolkit.getDefaultToolkit().beep();
    }
}