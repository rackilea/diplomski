import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Game extends JFrame {

    public final static int WIDTH = 700, HEIGHT = 450;
    public GamePanel panel;

    public Game() {
        setTitle("Game");
        setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new GamePanel(this);
        add(panel);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }

    public GamePanel getPanel() {
        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                new Game();
            }
        });
    }
}