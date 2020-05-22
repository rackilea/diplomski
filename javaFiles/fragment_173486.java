class SizeAndRegexFilter extends DocumentFilter {
  private int maxSize;
  private String regex;

  SizeAndRegexFilter (int maxSize,String regex) {
    this.maxSize=maxSize;
    this.regex=regex;

  } 
  public void insertString(FilterBypass fb, int offs,String str, AttributeSet a) throws BadLocationException {
    if ((fb.getDocument().getLength() + str.length()) <= maxSize && str.matches(regex))
        super.insertString(fb, offs, str, a);
    else
        Toolkit.getDefaultToolkit().beep();
  }

  public void replace(FilterBypass fb, int offs,int length, String str, AttributeSet a) throws BadLocationException {
    if ((fb.getDocument().getLength() + str.length()
             - length) <= maxSize  && str.matches(regex))
            super.replace(fb, offs, length, str, a);
        else
            Toolkit.getDefaultToolkit().beep();
  }
}