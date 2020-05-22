import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class PacMan extends JFrame {
    private static final long serialVersionUID = 1L;

    protected static final int NUM_ROWS = 14;
    protected static final int NUM_COLUMNS = 14;
    protected static String MAP[][];

    protected static JLabel status = new JLabel("Points: 0");

    public PacMan() {
        super("Pac Man");

        initializeMap();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(new GamePanel(), BorderLayout.CENTER);
        getContentPane().add(status, BorderLayout.NORTH);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void initializeMap() {
        int row = 0;
        MAP = new String[NUM_ROWS][NUM_COLUMNS];

        BufferedReader reader = null; 
        try {
            reader = new BufferedReader(new FileReader(new File("map.txt")));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(" ");
                if(columns.length == NUM_COLUMNS) {
                    for(int column = 0; column < columns.length; column++) {
                        MAP[row][column] = columns[column];
                    }
                }
                row++;
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(reader != null) {
                try {
                    reader.close();
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new PacMan();
                frame.setVisible(true);
            }
        });     
    }
}

class GamePanel extends JPanel implements KeyListener {
    private static final long serialVersionUID = 1L;

    private BufferedImage grass;
    private BufferedImage wall;
    private BufferedImage apple;
    private BufferedImage man;

    private int points = 0;
    private int currentPlayerRow = 1;
    private int currentPlayerCol = 1;

    public GamePanel() {
        try {
            addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);

            grass = ImageIO.read(new File("grass.png"));
            wall = ImageIO.read(new File("wall.png"));
            apple = ImageIO.read(new File("apple.png"));
            man = ImageIO.read(new File("man.png"));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // first, draw all grass in the screen to take advantage
        // of transparent images...
        for(int r = 0; r < PacMan.NUM_ROWS; r++) {
            for(int c = 0; c < PacMan.NUM_COLUMNS; c++) {
                g.drawImage(grass, c * 32, r * 32, null);
            }
        }

        // now just draw all objects (except grass) currently in map. you can 
        // change objects in the map array depending on your game logic elsewhere
        for(int r = 0; r < PacMan.NUM_ROWS; r++) {
            for(int c = 0; c < PacMan.NUM_COLUMNS; c++) {
                if(!PacMan.MAP[r][c].equals("0")) {
                    g.drawImage(getImage(PacMan.MAP[r][c]), c * 32, r * 32, null);
                }
            }
        }       
    }

    private Image getImage(String string) {

        if(string.equals("0")){
            return grass;
        }
        else if(string.equals("a")){
            return apple;
        }
        else if(string.equals("m")){
            return man;
        }       
        else {
            if(string.equals("1")){
                return wall;
            }
        }
        return null;
    }

    public Dimension getPreferredSize() {
        return new Dimension(PacMan.NUM_COLUMNS * 32, PacMan.NUM_ROWS * 32);
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}  
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_LEFT && !PacMan.MAP[currentPlayerRow][currentPlayerCol - 1].equals("1")) {
            PacMan.MAP[currentPlayerRow][currentPlayerCol] = "0";
            --currentPlayerCol;
        }
        else if(code == KeyEvent.VK_RIGHT && !PacMan.MAP[currentPlayerRow][currentPlayerCol + 1].equals("1")) {
            PacMan.MAP[currentPlayerRow][currentPlayerCol] = "0";
            ++currentPlayerCol;
        }
        else if(code == KeyEvent.VK_UP && !PacMan.MAP[currentPlayerRow - 1][currentPlayerCol].equals("1")) {
            PacMan.MAP[currentPlayerRow][currentPlayerCol] = "0";
            --currentPlayerRow;
        }
        else {
            if(code == KeyEvent.VK_DOWN && !PacMan.MAP[currentPlayerRow + 1][currentPlayerCol].equals("1")) {
                PacMan.MAP[currentPlayerRow][currentPlayerCol] = "0";
                ++currentPlayerRow;
            }
        }

        if(PacMan.MAP[currentPlayerRow][currentPlayerCol].equals("a")){
            points += 10;
            PacMan.status.setText("Points: " + points);
        }

        PacMan.MAP[currentPlayerRow][currentPlayerCol] = "m";
        repaint();
    }
}