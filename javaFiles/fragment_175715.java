public class Scale extends JFrame {

    public void generateGui() {
        JPanel main = new JPanel();
        main.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        main.setLayout(new BorderLayout());

        try {
            BufferedImage image = ImageIO.read(new File("path/to/image"));

            Image pawn = scale(image);
            JLabel pawnContainer = new JLabel(new ImageIcon(pawn));
            main.add(pawnContainer);
        } catch (IOException exp) {
            exp.printStackTrace();
        }

        add(main);

        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public BufferedImage scale(Image i) {
        BufferedImage resized = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resized.createGraphics();
        g.drawImage(i, 0, 0, 50, 50, this);
        g.dispose();
        return resized;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Scale imgObject = new Scale();
                imgObject.generateGui();
                imgObject.setVisible(true);
            }
        });
    }
}