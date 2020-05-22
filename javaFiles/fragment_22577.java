final Clipboard clipboard = Clipboard.getSystemClipboard();

copyMenu .setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent t) {            
        final ClipboardContent content = new ClipboardContent();
        content.putString("get test from textfield and put it here");
        clipboard.setContent(content);

    }
});