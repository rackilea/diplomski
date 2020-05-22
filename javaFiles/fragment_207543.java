public class ImagePanel extends JPanel {

    private Image img;
    private final List<MyImage> images = new ArrayList<MyImage>();

    // setImage methods

    public void addMyImage(MyImage image) {
        images.add(image);
    }
    // or/and
    public void addMyImage(Image image, int x, int y) {
        images.add(new MyImage(image, x, y));
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, this);    // check if img is null?
        for (MyImage image : images) {
            image.paint(g, this);
    }
}