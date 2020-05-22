textArea.addCaretListener(new CaretListener() {            
    @Override
    public void caretUpdate(CaretEvent e) {
        if(e.getMark() == e.getDot()){
            Highlighter hl = textArea.getHighlighter();
            hl.removeAllHighlights();

            String pattern = "<aa>";
            String text = textArea.getText();        
            int index = text.indexOf(pattern);
            while(index >= 0){
                try {                
                    Object o = hl.addHighlight(index, index + pattern.length(), DefaultHighlighter.DefaultPainter);
                    index = text.indexOf(pattern, index + pattern.length());
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
});