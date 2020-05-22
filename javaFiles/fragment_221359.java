JFileChooser chooser = new JFileChooser();
chooser.setMultiSelectionEnabled(false);
chooser.setAcceptAllFileFilterUsed(false);

FileNameExtensionFilter filter = new FileNameExtensionFilter("HTML Documents", "htm", "html");
chooser.setFileFilter(filter);

int option = chooser.showSaveDialog(ChatGUI.this);
if (option == JFileChooser.APPROVE_OPTION) {
    // Set up document to be parsed as HTML
    StyledDocument doc = (StyledDocument)textPaneHistory.getDocument();
    HTMLEditorKit kit = new HTMLEditorKit();

    BufferedOutputStream out;

    try {
        System.out.println(chooser.getFileFilter());

        if (chooser.getFileFilter() == filter)
            System.out.println("ha ha");
    }
}