public class TestPane extends JPanel {

    public TestPane() {
        setBackground(Color.RED);
        setLayout(new GridBagLayout());
        try {
            BufferedImage img = ImageIO.read(getClass().getResource("/1xaN3.png"));
            JButton btn = new JButton(new ImageIcon(img));
            btn.setOpaque(false);
            btn.setContentAreaFilled(false);
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);

            add(btn);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}