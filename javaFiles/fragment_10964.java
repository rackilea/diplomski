Path path = Paths.get("/Users/aa/Desktop/test.rtf";
try (Reader reader = Files.newBufferedReader(path)) {
    JEditorPane pane = new JEditorPane();
    pane.setContentType("text/rtf");
    EditorKit kit = pane.getEditorKitForContentType("text/rtf");
    Document doc = pane.getDocument();
    kit.read(reader, doc, 0);
    String text = doc.getText(0, doc.getLength());
    System.out.println();
}