textPane.setHighlighter( new CustomHighlighter() );

// ...

private final class CustomHighlighter extends DefaultHighlighter {

    @Override
    public Object addHighlight( int p0, int p1, HighlightPainter p ) throws BadLocationException {
       Object tag = super.addHighlight(p0, p1, p);
       /* notify embedded components ... */ 
       return tag;
    }

    @Override
    public void removeHighlight( Object tag ) {
        super.removeHighlight(tag);
       /* notify embedded components ... */ 
    }

    @Override
    public void removeAllHighlights() { 
        super.removeAllHighlights();
       /* notify embedded components ... */ 
    }

    @Override
    public void changeHighlight( Object tag, int p0, int p1 ) throws BadLocationException {
       super.changeHighlight(tag, p0, p1);
       /* notify embedded components ... */ 
    }
}