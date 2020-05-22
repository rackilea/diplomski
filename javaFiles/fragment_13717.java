@Override
public void replace(FilterBypass fb, int offs, int length,
        String str, AttributeSet a) throws BadLocationException {

    String text = fb.getDocument().getText(0,
            fb.getDocument().getLength());

    StringBuilder builder = new StringBuilder(text);
    builder.insert(offs, str);
    String newText = builder.toString();

    // check
    System.out.println("text = " + text 
                   + ", offset = " + offs 
                   + ", newText = " + newText);

    if (newText.matches("(-)?\\d*")) {
        super.replace(fb, offs, length, str, a);
    } else {
        Toolkit.getDefaultToolkit().beep();
    }
}