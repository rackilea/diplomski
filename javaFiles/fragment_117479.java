public static void main(String[] args) {
    JFrame frame = new JFrame("Dice Roll GUI");
    panel = new JPanel();
    JPanel contentPanel = new JPanel(new GridLayout(0, 2, 5, 10));
    button = new JButton("Roll");

    // !! Add this !! //
    diceRoll = new JLabel();
    contentPanel.add(diceRoll);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    button.setActionCommand("Roll");
    button.addActionListener(new RollButton(diceRoll));
    button.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.setPreferredSize(new Dimension(750, 500));
    panel.setLayout(new BorderLayout());
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panel.add(button, BorderLayout.NORTH);
    panel.add(contentPanel);
    frame.setContentPane(panel);
    frame.pack();
    frame.setVisible(true);
}