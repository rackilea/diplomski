String pattern = "<aa>";
String text = textArea.getText();        
int index = text.indexOf(pattern);
while(index >= 0){
    try {                
        hl.addHighlight(index, index + pattern.length(), DefaultHighlighter.DefaultPainter);
        index = text.indexOf(pattern, index + pattern.length());            
    } catch (BadLocationException ex) {
        ex.printStackTrace();
    }
}