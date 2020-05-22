public class CloseCanvas extends Canvas{

    private static final long serialVersionUID = 2L;
    BufferedImage image = null;

    CloseCanvas() {
        try {
            image = ImageIO.read(new File("res/close.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setPreferredSize(new Dimension(30,22));
    }


    @Override
    public void paint(Graphics g) {
        if (image!=null) {
            g.drawImage(image, 0, 0, this);
        }
    }
}