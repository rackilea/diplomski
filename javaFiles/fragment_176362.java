public class Panel extends JPanel
{
    BufferedImage image;

    public Panel() {
        super();

        try {
            image = ImageIO.read(new File("images/BMW-TA.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}