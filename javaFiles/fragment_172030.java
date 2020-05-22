public static void copyContent(JTextPane jtp, String text, int offset) {
    try {
        boolean start = offset>0 ? !jtp.getText(offset-1, 1).equals("\n") : false;
        Position p = jtp.getDocument().createPosition(offset);
        new HTMLEditorKit().read(new StringReader(html), jtp.getHTMLdoc(), offset);
        if(start) {jtp.getDocument().remove(offset, 1);}
        if(offset>0) {jtp.getDocument().remove(p.getOffset()-1, 1);}
    } catch (IOException | BadLocationException ex) {
        Logger.getLogger(EditeurIO.class.getName()).log(Level.SEVERE, null, ex);
    }
}