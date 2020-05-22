public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());
    frame.getContentPane().setBackground(Color.GREEN);

    JLabel label1 = new JLabel("label1");
    label1.setBackground(Color.RED);
    label1.setOpaque(false);
    frame.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            label1.setOpaque(!label1.isOpaque());
            label1.setBackground(label1.getBackground() == Color.RED ? Color.BLUE : Color.RED);
        }
        public void mouseReleased(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
    });

    frame.add(label1);
    frame.pack();
    frame.setVisible(true);
}