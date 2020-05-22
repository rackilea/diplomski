public static void main(String[] args) {
    JFrame frame = new TestScrollPane();
    JPanel panel = new JPanel();
    JTable table = new JTable();

    panel.setLayout(new BorderLayout());
    panel.add(new JLabel("NORTH"), BorderLayout.NORTH);
    panel.add(new JLabel("SOUTH"), BorderLayout.SOUTH);

    JScrollPane sp = new JScrollPane(table);
    sp.setBorder(BorderFactory.createEmptyBorder());
    panel.add(sp, BorderLayout.CENTER);
    frame.add(panel);

    frame.setVisible(true);
}