link.setOnMouseClicked(event -> {
        if (event.getSource().equals(MouseButton.MIDDLE)) {
            final Clipboard cb = Clipboard.getSystemClipboard();
            final ClipboardContent content = new ClipboardContent();
            content.putString(link.getText());
            cb.setContent(content);
        }
    });