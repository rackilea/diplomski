private DefaultHighlightPainter highlightOne =  new DefaultHighlightPainter(Color.RED);
private Object last;

public void paintAt(int pos){
    try {
        if (last != null){
            textPane.getHighlighter().removeHighlight(last);
        }
        last = textPane.getHighlighter().addHighlight(pos, pos + searchWordLength, highlightOne);
    } catch (BadLocationException e) {
        //TODO
    }
}