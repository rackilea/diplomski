public class Sprite {
    ....
    public Sprite(int x, int y) {
       this.x = x;
       this.y = y;
    }
    ....
}

    public class Brick extends Sprite {
        ....
        public Brick(int x, int y) {
            // Call the sprite constructor
            super(x, y);

            ImageIcon ii = new ImageIcon("images/bricks.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            destroyed = false;
        }
        ....
    }