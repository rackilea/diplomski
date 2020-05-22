editorPane.setContentType("text/html");
HTMLEditorKit kit = new HTMLEditorKit();
editorPane.setEditorKit(kit);
File cssfile = new File("src/Assets/code.css");

StyleSheet styleSheet = kit.getStyleSheet();
styleSheet.importStyleSheet(cssfile.toURI().toURL());

editorPane.setText("<html><head></head><body><pre></pre></body></html>");