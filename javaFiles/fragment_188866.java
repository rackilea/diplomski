public TestGameBoard() {
    layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(new Dimension(680, 680));
    layeredPane.setBackground(Color.GREEN);
    layeredPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    layeredPane.setOpaque(true);

    setLayout(new BorderLayout()); // Easy to use layout manager
    add(layeredPane); // Now I'm visible ;)
}