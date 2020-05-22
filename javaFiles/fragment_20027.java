@Override  
 public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException 
 {  

     fb.insertString(offset, "", null);
 }