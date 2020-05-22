public static void highlight(JTextComponent textComp, String pattern) {

    try {
        Highlighter hilite = textComp.getHighlighter();

        String text = textComp.getText();
        String line =null;
        int start = 0;
        int end;
        int totalLines = ((JTextArea) textComp).getLineCount();
        for (int i=0; i < totalLines; i++) {

            if(i==5){ //Line Numbers Decrement by 1
            start = ((JTextArea) textComp).getLineStartOffset(i);
            end   = ((JTextArea) textComp).getLineEndOffset(i);
            line = text.substring(start, end);
            System.out.println("My Line: " + line);
            System.out.println("Start Position of Line: " + start);
            System.out.println("End Position of Line: " + end);
            }
        }
        int pos = start;

        // Search for pattern
        if ((pos =text.indexOf(pattern, pos)) >= start) {
            // Create highlighter using private painter and apply around pattern
            hilite.addHighlight(pos, pos + pattern.length(), painter2);
            pos += pattern.length();
        }
    } catch (BadLocationException e) {
    }
}