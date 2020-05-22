public void findOccurrences() throws BadLocationException {  
    Highlighter highlighter = textArea.getHighlighter();        
    DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);

    highlighter.removeAllHighlights();        

    if( keyWord.isEmpty() )
        return;

    Pattern pattern = Pattern.compile( Pattern.quote(keyWord) );
    Matcher matcher = pattern.matcher(textArea.getText());                    

    while(matcher.find()) {
        highlighter.addHighlight(matcher.start(), matcher.end(), painter);
    }
}