messagePane = new JTextPane();
messagePane.setEditable(false);
messagePane.setEditorKit(new StyledEditorKit());
MessageDocument doc = new MessageDocument();
doc.addDocumentListener(new SmileyDocumentListener(messagePane));
messagePane.setStyledDocument(doc);