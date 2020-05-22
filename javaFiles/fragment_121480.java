public static void main(String[] args) throws Exception {
    JTextPane pane = new JTextPane();

    Style regular = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
    Style invisible = pane.getStyledDocument().addStyle("invisible", regular);
    StyleConstants.setFontSize(invisible, 0);
    StyleConstants.setForeground(invisible, pane.getBackground());
    pane.getStyledDocument().insertString(pane.getStyledDocument().getLength(), 
            "Hello, ", null);
    pane.getStyledDocument().insertString(pane.getStyledDocument().getLength(), 
            "cruel ", pane.getStyledDocument().getStyle("invisible"));
    pane.getStyledDocument().insertString(pane.getStyledDocument().getLength(), 
            "world!", null);
    pane.setPreferredSize(new Dimension(500, 500));

    JFrame frame = new JFrame();
    frame.setLayout(new BorderLayout());
    frame.add(pane, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack(); frame.setVisible(true);
}