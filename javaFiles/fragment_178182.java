public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String string, AttributeSet attr){
  System.out.print("replace invoked");
  try {
    super.insertString(fb, offset, "; You inserted the string: "+string, attr);
  } catch (BadLocationException e) {
    e.printStackTrace();                                                                                                                                                            
  }                                                                                                                                                                                   
}