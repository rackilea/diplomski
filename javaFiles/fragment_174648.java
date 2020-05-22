import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComponent;

public class Board extends JComponent {
    private static final long serialVersionUID = 3669634976765884468L;

    public String[] gameElements = new String[100];
    private Tile[] tiles = new Tile[100];
    private String[][] map = new String[10][10];
    private String currentLevel;
    private boolean isInitialized;

    public Board(String level) {
        isInitialized = false;

        loadLevel(level);

        currentLevel = level;
        isInitialized = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isInitialized) {
            int i = 0;

            g.clearRect(0, 0, this.getWidth(), this.getHeight());

            for (int y = 0; y < map.length; y++) {
                for (int x = 0; x < map.length; x++) {
                    tiles[i].paintComponent(g);
                    map[y][x] = tiles[i].getLabel();
                    System.out.printf("[%s]", map[y][x]);
                    i++;
                }

                System.out.println();
            }
        }
    }

    public void readTextFile(String level) {
        ClassLoader loader = Board.class.getClassLoader();
        String filename = "resources/" + level + ".txt";
        InputStream stream = null;
        Scanner scan = null;

        try {
            stream = loader.getResourceAsStream(filename);
            scan = new Scanner(stream);

            scan.useDelimiter("[,]([\r\n]+)?");

            int i = 0;
            while (scan.hasNext()) {
                gameElements[i] = scan.next().trim();
                i++;
            }

            scan.close();
            stream.close();
        } catch (IOException e) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void generateTiles() {
        int i = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map.length; x++) {
                tiles[i] = new Tile(x, y, gameElements[i]);
                i++;
            }
        }
    }

    public void loadLevel(String level) {
        readTextFile(level);
        generateTiles();
    }
}