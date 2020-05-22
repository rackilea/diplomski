import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PaintTiles extends JPanel {

    BufferedImage playerImg;
    BufferedImage tileImg;
    Map map;
    Player player;
    int playerX, playerY;

    public PaintTiles() throws MalformedURLException, IOException {
        playerImg = ImageIO.read(new URL("http://th05.deviantart.net/fs71/PRE/f/2013/055/0/d/super_mario_by_tachin-d5w51ob.png"));
        tileImg = ImageIO.read(new URL("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTc0ep9G8CyvdJSpBbn8AFdZDlimas7Hcc6jqiVVxBe4nfWJYQy7A"));

        map = new Map(tileImg);

        playerX = 250;
        playerY = 250;
        player = new Player(playerX, playerY, 100, 100, playerImg);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (map != null && player != null) {
            map.paintTiles(g);
            player.paintPlayer(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(640, 480);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Test");
                try {
                    frame.add(new PaintTiles());
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(PaintTiles.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}

class Map {

    Image img;
    Tile[][] tiles;

    int tileSize = 32;
    private static final int SCREEN_W = 640;
    private static final int SCREEN_H = 480;
    int xInc = SCREEN_W / tileSize;
    int yInc = SCREEN_H / tileSize;


    public Map(Image img) {
        this.img = img;
        tiles = new Tile[xInc][yInc];

        for (int x = 0; x < xInc; x++) {
            for (int y = 0; y < yInc; y++) {
                tiles[x][y] = new Tile(x * tileSize, y * tileSize, tileSize, tileSize, img);
            }
        }
    }

    public void paintTiles(Graphics g) {
        if (tiles != null) {
            for (Tile[] tile : tiles) {
                for (Tile t : tile) {
                    t.drawTile(g);
                }
            }
        }
    }
}

class Player {

    int x, y, w, h;
    Image player;

    public Player(int x, int y, int w, int h, Image player) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.player = player;
    }

    public void paintPlayer(Graphics g) {
        g.drawImage(player, x, y, w, h, null);
    }
}

class Tile {

    int x, y, w, h;
    Image img;

    public Tile(int x, int y, int w, int h, Image img) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.img = img;
    }

    public void drawTile(Graphics g) {
        g.drawImage(img, x, y, w, h, null);
    }
}