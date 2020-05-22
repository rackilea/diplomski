public static void main(String[] args) throws IOException {

    JFrame frame = new JFrame("Test");

    frame.setContentPane(new JPanel() {
        BufferedImage image = ImageIO.read(new URL("http://upload.wikimedia.org/wikipedia/en/2/24/Lenna.png"));
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, 300, 300, this);
        }
    });

    frame.add(new JButton("Test Button"));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.setVisible(true);
}