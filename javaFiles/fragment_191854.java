import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class JavaGame extends JPanel {

    int x, y;
    private Image dbImage;
    private Graphics dbg;
    Image ghost;
    Image bg;

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if (keyCode == e.VK_LEFT) {
                if (x <= 8)
                    x = 8;
                else
                    x += -5;
            }
            if (keyCode == e.VK_RIGHT) {
                if (x >= 235)
                    x = 235;
                else
                    x += +5;
            }
            if (keyCode == e.VK_UP) {
                if (y <= 18)
                    y = 18;
                else
                    y += -5;
            }
            if (keyCode == e.VK_DOWN) {
                if (y >= 235)
                    y = 235;
                else
                    y += +5;
            }
        }

        public void keyReleased(KeyEvent e) {
        }
    }

    public JavaGame() throws Exception {
        // Load images
        //ImageIcon i = new ImageIcon(
            //  "C:/Users/Taylor/workspace/Java game/src/ghost.png");
        URL urlGhost = new URL("http://1point1c.org/gif/thum/plnttm.gif");
        ghost = Toolkit.getDefaultToolkit().createImage(urlGhost);

        //ImageIcon j = new ImageIcon(
            //  "C:/Users/Taylor/workspace/Java game/src/bg.png");
        URL urlBG = new URL("http://pscode.org/media/stromlo2.jpg");
        bg = Toolkit.getDefaultToolkit().createImage(urlBG);

        setFocusable(true);

        // Game properties
        addKeyListener(new AL());
        x = 150;
        y = 150;

        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                repaint();
            }
        };
        Timer timer = new Timer(50,al);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, null);

        //dbImage = createImage(getWidth(), getHeight());
        //dbg = dbImage.getGraphics();
        //paintComponent(dbg);
        g.drawImage(dbImage, x, y, this);

        g.setColor(Color.WHITE);
        g.drawImage(ghost, x, y, this);

        //repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame f = new JFrame("Java Game");
                    f.setSize(500, 500);
                    f.setResizable(false);
                    f.setVisible(true);
                    f.setBackground(Color.GRAY);
                    f.setContentPane(new JavaGame());
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}