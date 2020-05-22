Highlighter h = textArea.getHighlighter();
h.removeAllHighlights();
int pos = originalText.indexOf(summaryText, 0);
h.addHighlight(pos ,
               pos  + summaryText.Length,
               DefaultHighlighter.DefaultPainter);