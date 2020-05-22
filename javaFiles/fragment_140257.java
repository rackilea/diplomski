String text = "Potentially looooooong text. " + 
    "Lorem ipsum dolor sit amet, consectetuer" +
    "adipiscing elit, sed diam nonummy nibh euismod " +
    "tincidunt ut laoreet dolore magna aliquam" + 
    "adipiscing elit, sed diam nonummy nibh euismod" + 
    "erat volutpat. Ut wisi enim ad minim veniam, " + 
    "quis nostrud exerci tation.";

final JEditorPane editorPane = new JEditorPane("text/html", text);
editorPane.setSize(300, Integer.MAX_VALUE);
editorPane.setEditable(false);