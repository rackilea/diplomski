Highlighter.Highlight myHighlight = null;
Highlighter.Highlight[] highlights = textPane.getHighlighter().getHighlights();
myHighlight = highlights[0]; //assuming there is one only

try {
      hl.changeHighlight(myHighlight, myHighlight.getStartOffset()+1, myHighlight.getEndOffset());
}
catch(BadLocationException e) {
      e.printStackTrace();
}