ContextMenu copyMenu = new ContextMenu();
MenuItem copyLink = new MenuItem("Copy link...");
copyLink.setOnAction(event ->  {
    final Clipboard cb = Clipboard.getSystemClipboard();
    final ClipboardContent content = new ClipboardContent();
    content.putString(link.getText());
    cb.setContent(content);
});