JTextPane textPane = new JTextPane();
    JButton button = new JButton("Button");     
    button.setAlignmentY(0.85f);

    HTMLEditorKit kit = new HTMLEditorKit();
    HTMLDocument doc = new HTMLDocument();
    textPane.setEditorKit(kit);
    textPane.setDocument(doc);

    try {
        kit.insertHTML(doc, doc.getLength(), "<p color='#FF0000'>Cool!", 0, 0, HTML.Tag.P);
        kit.insertHTML(doc, doc.getLength(), "<p></p>", 0, 0, null);
    } catch (BadLocationException ex) {
    } catch (IOException ex) {
    }