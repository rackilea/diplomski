public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            SimplePaint s = new SimplePaint();
            s.setVisible(true);
        }
    });
}