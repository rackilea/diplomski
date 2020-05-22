JTextArea textArea = new JTextArea(10, 20);
textArea.setText( "one\ntwo\nthree\nfour\nfive\nsix\nseven\neight" );

DefaultHighlighter highlighter =  (DefaultHighlighter)textArea.getHighlighter();
highlighter.setDrawsLayeredHighlights(false);

try
{
    highlighter.addHighlight(10, 20, new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW));
}
catch(Exception e) {}