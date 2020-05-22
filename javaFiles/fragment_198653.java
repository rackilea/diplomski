import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyGame extends JPanel implements ActionListener, KeyListener {
    Timer t = new Timer(5, this);
    int x = 0, y = 0, velx =0, vely =0, g = 0;
    private Color color;

    public MyGame() {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 1000);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(x, y, 50, 30);



    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        {
            if (code == KeyEvent.VK_DOWN) {
                vely = 1; // removing velx = 0 allows us to go vertically and horizontlly at the same time

            }
            if (code == KeyEvent.VK_UP) {
                vely = -1; // same goes for here

            }
            if (code == KeyEvent.VK_LEFT) {

                velx = -1;
            }

            {
                if (code == KeyEvent.VK_RIGHT) {

                    velx = 1;

                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        velx = 0;
        vely = 0;
    }




    public static void main (String arge[]){

        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new Incoming());           
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}