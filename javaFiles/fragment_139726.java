import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JavaGame2 extends JPanel implements KeyListener, Runnable {

//variables
    int x, y, xDir, yDir;
    Rectangle bullet;
    boolean readyTofire, shot = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JavaGame2());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
    }

//constructor for game
    public JavaGame2() {

        int x = 150;
        int y = 150;
        this.setBackground(Color.WHITE);

        setFocusable(true);
        addKeyListener(this);
        requestFocusInWindow();

        Thread t = new Thread(this);
        t.start();

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

//drawings
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        Rectangle rec = new Rectangle(50, 20, 50, 50);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 55, 55);
        g.fillRect(x + 23, y - 15, 10, 20);
        g.setColor(Color.RED);
        g.fillRect(rec.x, rec.y, rec.width, rec.height);

        if (shot && bullet != null) {
            g2d.setColor(Color.BLACK);
            g2d.fill(bullet);

            if (bullet.intersects(rec)) {
                g2d.drawString("collision!", 50, 20);
            }
        }
        g2d.dispose();

    }

    public void setxDir(int xdir) {
        xDir = xdir;
    }

    public void setyDir(int ydir) {
        yDir = ydir;
    }

//key event listener keypressed
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            setyDir(-1);
        }
        if (code == KeyEvent.VK_DOWN) {
            setyDir(+1);
        }
        if (code == KeyEvent.VK_LEFT) {
            setxDir(-1);
        }
        if (code == KeyEvent.VK_RIGHT) {
            setxDir(+1);

        }
        if (code == KeyEvent.VK_SPACE) {
            readyTofire = true;
            if (readyTofire) {
                int bx = x + 26;
                int by = y - 15;
                bullet = new Rectangle(bx, by, 5, 3);
                shot = true;
            }
        }
    }

//key event listener for key released
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            setyDir(0);
        }
        if (code == KeyEvent.VK_DOWN) {
            setyDir(0);
        }
        if (code == KeyEvent.VK_LEFT) {
            setxDir(0);
        }
        if (code == KeyEvent.VK_RIGHT) {
            setxDir(0);

        }
//        if (code == KeyEvent.VK_SPACE) {
//            readyTofire = false;
//            if (bullet.y <= -5) {
//                bullet = new Rectangle(0, 0, 0, 0);
//                shot = false;
//                readyTofire = true;
//
//            }
//        }
    }

    public void keyTyped(KeyEvent e) {

    }

//shot of bullet
    public void shoot() {

        if (shot) {
            bullet.y--;
            if (bullet.y < 0) {
                shot = false;
                bullet = null;
            }
        }

    }

//movement of the oval
    public void move() {
        x += xDir;
        y += yDir;
        if (x <= 0) {
            x = 0;
        } else if (x >= 500) {
            x = 500;
        } else if (y <= 0) {
            y = 0;
        } else if (y >= 500) {
            y = 500;
        }

    }

//thread
    public void run() {

        try {
            while (true) {
                shoot();
                move();
                repaint();

                Thread.sleep(40);
            }

        } catch (Exception e) {
            System.out.println("error!");
        }
    }

}