static void readin(String fn, JTextComponent pane) {
    try {
        FileReader fr = new FileReader(fn);
        pane.read(fr, null);
        fr.close();
        Highlighter hilit = new DefaultHighlighter();
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
        pane.setHighlighter(hilit);
        hilit.addHighlight(getLineEndIdx(pane.getText(), 4), getLineEndIdx(pane.getText(), 8 ), painter);
    }
    catch (IOException e) {
        System.err.println(e);
    } catch (BadLocationException e) {
        e.printStackTrace();
    }
}

private static int getLineEndIdx(String text, int lineNo) {
    int lineEndIdx = 0;
    for(int i = 1; i <= lineNo && lineEndIdx + 1 < text.length(); i++)
    {
        lineEndIdx = text.indexOf('\n', lineEndIdx + 1) ;
    }
    return lineEndIdx;
}