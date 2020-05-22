private class HighlightCaret extends DefaultCaret {

    private final Highlighter.HighlightPainter unfocusedPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
    private final Highlighter.HighlightPainter focusedPainter = new DefaultHighlighter.DefaultHighlightPainter(new Color(10, 36, 106));
    private boolean isTemporary;

    private HighlightCaret() {
        setBlinkRate(500);
    }

    @Override
    protected Highlighter.HighlightPainter getSelectionPainter() {
        return isTemporary ? unfocusedPainter : focusedPainter;
    }

    @Override
    public void setSelectionVisible(boolean hasFocus) {
        super.setSelectionVisible(false);
        if (hasFocus) {
            super.setSelectionVisible(true);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        isTemporary = false;
        super.focusGained(e);
    }

    @Override
    public void focusLost(FocusEvent e) {
        isTemporary = e.isTemporary();
        super.focusLost(e);
    }
}