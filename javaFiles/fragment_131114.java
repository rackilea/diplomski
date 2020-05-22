public class Brick extends Sprite {
    ....
    public Brick(int x, int y) {

        ImageIcon ii = new ImageIcon("images/bricks.png");
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);

        destroyed = false;

        // Save these
        this.x = x;
        this.y = y
    }
    ....
}