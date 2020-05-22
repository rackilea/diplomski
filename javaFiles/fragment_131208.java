VerifyListener verify = new VerifyListener() {
  public void verifyText(VerifyEvent event) {
    event.doit = false;

    if (Character.isDigit(event.character) {
        || Character.isWhitespace(event.character)
        || event.character == '.' 
        || event.character == ','
        || event.character == '#'
        || event.character == '*'
        || event.character == '/'
        || event.character == '('
        || event.character == ')' 
        || event.character == '['
        || event.character == ']'
        || event.character == '-'
        || event.keyCode == SWT.ARROW_LEFT
        || event.keyCode == SWT.ARROW_RIGHT
        || event.keyCode == SWT.BS
        || event.keyCode == SWT.DEL) {

      event.doit = true;
    }
  }
};