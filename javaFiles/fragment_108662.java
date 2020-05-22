public class Tile {
    public static int CORNER_TILE = 0;
    public static int SIDE_TILE = 1;
    public static int CENTRE_TILE = 2;

    public int x, y, type;

    public Tile(int type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    } 
    public void render(Graphics g) {
        //Insert rendering code for each different tile type
        //For example:

        if (this.type == Tile.CENTRE_TILE) {
            g.drawImage(Main.someTileImage, x * 32, y * 32);
            //Multiply x and y by dimensions of tile
        }
   }
}