import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class GUI extends JFrame {
    GameCanvas canvas = new GameCanvas();
    final int FRAME_HEIGHT = 400;
    final int FRAME_WIDTH = 400;


    public GUI() {
        // build and display your GUI
        super("Game");

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem startMenuItem = new JMenuItem("Pause");
        menuBar.add(fileMenu);
        fileMenu.add(startMenuItem);

        super.add(canvas);
        super.setVisible(true);
        super.setSize(FRAME_WIDTH, FRAME_WIDTH);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setJMenuBar(menuBar);
    }
}

public class Main {

    public static void main(String args[]) {
        GUI ui = new GUI(); // create and display GUI        

        gameLoop(); // start the game loop
    }

    static void gameLoop() {
        // game loop    
    }
}