static void readin(String fn, JTextComponent pane) {
    try {
        FileReader fr = new FileReader(fn);
        pane.read(fr, null);
        fr.close();
        Highlighter hilit = new DefaultHighlighter();
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
        pane.setHighlighter(hilit);
        hilit.addHighlight(0, pane.getText().indexOf("\n"), painter);
    }
    catch (IOException e) {
        System.err.println(e);
    } catch (BadLocationException e) {
        e.printStackTrace();
    }
}