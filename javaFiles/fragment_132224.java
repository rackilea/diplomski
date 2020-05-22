public class Menu extends JPanel {

    private Image backgroundImage;

    public static void main(final String[] args) throws IOException {
        Menu menu = new Menu();
        JFrame frame = new JFrame();
        frame.setContentPane(menu);
        frame.setBounds(100, 100, 312, 294);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Menu() throws IOException {
        initialize();
    }

    public void initialize() throws IOException {

        backgroundImage = ImageIO.read(new File("P:\\Profiles\\workspace\\Games\\Images\\matrix.jpg"));

    }

    @Override
    public void paintComponent(final Graphics g){

        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);

    }

}