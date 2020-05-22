Highlighter.Highlight[] highlights = pseudoCodeTextPane.getHighlighter().getHighlights();
 int[] startOffsets = new int[highlights.length];
 int[] endOffsets = new int[highlights.length];
 for (int i = 0; i < highlights.length; ++i) {
     startOffsets[i] = highlights[i].getStartOffset();
     endOffsets[i] = highlights[i].getEndOffset();
 }
 pseudoCodeTextPane.getHighlighter().removeAllHighlights();
 // now do whatever processing you want to do with the highlight locations