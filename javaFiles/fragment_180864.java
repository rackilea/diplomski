public static void main(String[] args) throws Exception {

    JFrame frame = new JFrame("Test");
    frame.setLayout(new GridLayout(0, 1));
    frame.add(new JButton("Hello"));
    frame.add(new JLabel("World", JLabel.CENTER));
    frame.add(new JButton("Hello"));
    frame.add(new JLabel("World", JLabel.CENTER));

    for (Component c : frame.getContentPane().getComponents()) {
        if (c instanceof JLabel) {
            ((JLabel) c).setText("Friend");
            c.setForeground(Color.RED);
        }
    }

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
}