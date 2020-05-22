EventQueue.invokeLater(() -> {
    JFrame frame = new JFrame("Stackoverflow | Question");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.setLocationRelativeTo(null);
    // This is the important line. This will Change the layout to a GridLayout.
    frame.setLayout(new GridLayout(4, 1));
    frame.add(new JLabel("0-29"));
    frame.add(new JLabel("30-39"));
    frame.add(new JLabel("40-69"));
    frame.add(new JLabel("70-100"));
    frame.setVisible(true);
});