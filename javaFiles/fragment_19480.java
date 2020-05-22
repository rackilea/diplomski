public class NewClass extends javax.swing.JFrame {

    JLabel o = new JLabel();

    public NewClass() {
        initComponents();

        createImage("background.png");
        add(o);
        setVisible(true);
        setSize(100, 100);
        setResizable(false);

        o.setLocation(20, 20);
        o.setSize(100, 25);
    }

    public void createImage(String str) {
        URL url = getClass().getResource(str);
        try {
            BufferedImage image = ImageIO.read(url);
            o.setIcon(new ImageIcon(image));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
....
}