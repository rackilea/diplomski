@Override
public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attr)
        throws BadLocationException {
    if ("b".equalsIgnoreCase(str)) {
        super.replace(fb, 0, fb.getDocument().getLength(), "", attr);
        return;
    } else {
        super.replace(fb, offset,length, str, attr);
    }  
}