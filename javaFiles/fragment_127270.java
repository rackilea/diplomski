JTextPane text_panel = new JTextPane();
    HTMLEditorKit kit = new HTMLEditorKit();
    HTMLDocument doc = new HTMLDocument();
    text_panel.setEditorKit(kit);
    text_panel.setDocument(doc);
    kit.insertHTML(doc, doc.getLength(), "<b>hello", 0, 0, HTML.Tag.B);
    kit.insertHTML(doc, doc.getLength(), "<font color='red'><u>world</u></font>", 0, 0, null);