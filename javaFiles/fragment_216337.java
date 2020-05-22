public class panel extends JPanel {

    Image img;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        }
        // g.dispose();
    }

    public panel() {
         img=new ImageIcon(getClass().getResource("bg_login.jpg")).getImage();

    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        panel panel = new panel();
        jFrame.setContentPane(panel);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}