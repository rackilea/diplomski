public class MyImage {    // or SubImage?
    private Image image;
    private int x;
    private int y;

    public MyImage(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g, ImageObserver obs) {
        g.drawImage(image, x, y, obs);
    }

    // getters and setters
}