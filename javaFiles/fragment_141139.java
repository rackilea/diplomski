BufferedImage test = null;

public static void main(String[] args) throws URISyntaxException {
    new JFrameTesting();
}
public JFrameTesting() throws URISyntaxException {
    JFrame frame = new JFrame("My first JFrame!");
    JLabel label = new JLabel();
    frame.setSize(800, 800);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    try {
        test = ImageIO.read(new File(getClass().getResource("test.png").toURI())); 
        frame.add( new JLabel(new ImageIcon(test)),BorderLayout.CENTER);
        frame.setIconImage(test);
        frame.setVisible(true);
        label.setVisible(true);
    } catch (IOException ex) {
        Logger.getLogger(JFrameTesting.class.getName()).log(Level.SEVERE, null, ex);
    }
}


public void paint(Graphics g) {
    super.paint(g);
    g.drawImage(test, 200, 200, null);
}