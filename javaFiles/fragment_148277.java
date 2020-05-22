public class DrawQuestion extends JPanel{
    private static final long serialVersionUID = 1L;

    private Image image1;
    public DrawQuestion() {
        image1 = new ImageIcon(this.getClass().getResource("Page1.png")).getImage();
    }

    public Dimension getPreferredSize() {
        return image1 == null ? super.getPreferredSize() : new Dimension(image1.getWidth(this), image1.getHeight(this));
    }

    public void paintComponent(Graphics g){ 
        super.paintComponent(g);

        if (image1 != null) {
            g.drawImage(image1,0,0,this);
        }
    }
}