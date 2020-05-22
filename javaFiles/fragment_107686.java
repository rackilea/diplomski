CellValue myValue = (CellValue)value;
HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(
        Color.green);
textField.getHighlighter().removeAllHighlights();
try {
    textField.getHighlighter().addHighlight(myValue.highlightStart, myValue.highlightEnd, painter);
} catch (BadLocationException e) {
    System.out.println("Miss");
}