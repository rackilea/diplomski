public void removeUpdate(DocumentEvent e) {
    //maybeScrollToBottom();
    int lineHeight = jTextArea.getPreferredSize().height / jTextArea.getLineCount();
    JViewport viewport = jScrollPane.getViewport();
    Point position = viewport.getViewPosition();
    position.y -= lineHeight;

    if (position.y > 0 )
        viewport.setViewPosition(position);
}