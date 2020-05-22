SwingNode imageNode = new SwingNode();

URL url = new URL(urlSpec);
EventQueue.invokeAndWait(() -> {
    ImageIcon icon = new ImageIcon(url);
    JLabel imageLabel = new JLabel(icon);
    icon.setImageObserver(imageLabel);
    imageNode.setContent(imageLabel);
});