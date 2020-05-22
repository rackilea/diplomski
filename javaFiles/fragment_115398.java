ToolTipTest() {
    JFrame frame = new JFrame("Tool tip test");
    frame.setLocationByPlatform(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Holds the component group and the glass pane
    JComponent content = new JPanel();
    content.setLayout(new OverlayLayout(content));
    frame.add(content);
    JComponent glassPane = new JComponent(){};
    content.add(glassPane);
    final JPanel bg = new JPanel(new BorderLayout());
    content.add(bg);
    bg.add(new JLabel("Tooltip shows here"), BorderLayout.NORTH);
    JTextPane text = new JTextPane();
    try {
        text.getStyledDocument().insertString(0, "The same tooltip also shows here", null);
    } catch (BadLocationException e) {
        e.printStackTrace();
    }
    text.setEditable(false);
    text.setFocusable(false);
    bg.add(text);
    glassPane.setToolTipText("A tooltip, that shows on both the label and the text");
    JLabel other = new JLabel("This component has another tooltip");
    other.setToolTipText("Another tooltip");
    frame.add(other, BorderLayout.SOUTH);

    frame.pack();
    frame.setVisible(true);
}