public static void main(String[] args) {
    JFrame frame = new JFrame("COLLIN");
    frame.setSize(1086, 1200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel label = new JLabel("my text", SwingConstants.CENTER);
    frame.setResizable(false);
    frame.add(label);
    frame.setVisible(true);
}