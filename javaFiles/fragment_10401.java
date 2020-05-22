import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SideScroller extends JPanel implements KeyListener {

    public static void main(String args[]) throws Exception {
        SideScroller f = new SideScroller("Side Scroller");
    }

    JFrame f = new JFrame();
    int x = 0;
    int y = 0;
    int k = 10;
    int j = 50;
    int characterY = 351;
    boolean canJump = true;
    boolean keyPressed[] = new boolean[3];

    Image img;
    Image character;

    Coins c = new Coins(x + 500, y + 350);

    public SideScroller(String s) throws MalformedURLException, IOException {
        img = ImageIO.read(new URL("http://dl.dropbox.com/u/47632315/sideScrollerBG.png"));
        character = ImageIO.read(new URL("http://dl.dropbox.com/u/47632315/char.png"));

        f.setTitle(s);
        // don't use 'magic numbers' when descriptive constants are defined!
        //f.setDefaultCloseOperation(3);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        // Better to ask when loaded.
        //setPreferredSize(new Dimension(1000, 500));
        setPreferredSize(new Dimension(1000, img.getHeight(this)));
        f.add(this);
        f.pack();
        // usually harmful, rarely necessary.
//      f.setLayout(null);
        // Looks like a splash screen
        //f.setLocationRelativeTo(null);
        // located by platform default, best.
        f.setLocationByPlatform(true);
        f.addKeyListener(this);
        getKeys();

        // should be done last
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, x, y, this);
        g.drawImage(character, 50, characterY, this);
        Graphics2D g2d = (Graphics2D)g;
        // here we 'translate' the graphics object to a separate location  
        g2d.translate(x,0);
        c.paint(g2d, this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            keyPressed[0] = true;
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            keyPressed[1] = true;
        }
        if (canJump) {
            if (keyCode == KeyEvent.VK_SPACE) {
                // better to use a javax.swing.Timer here
                new Thread(new Runnable() {
                    public void run() {
                        canJump = false;
                        for (double i = 0; i <= 5.1; i += .2) {
                            characterY = (int) (k * i * i - j * i + 351);
                            f.repaint();
                            System.out.println(characterY);
                            System.out.println(canJump);
                            try {
                                Thread.sleep(25);
                            } catch (InterruptedException e) {
                                System.err.println(e);
                            }
                        }
                        repaint();
                        canJump = true;
                    }
                }).start();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_RIGHT) {
            keyPressed[0] = false;
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            keyPressed[1] = false;
        }
    }

    public void getKeys() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    if (keyPressed[0]) {
                        x -= 5;
                        repaint();
                    }
                    if (keyPressed[1]) {
                        if (x != 0) {
                            x += 5;
                            repaint();
                        }
                    }
                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException e) {
                        System.err.println(e);
                    }
                }
            }
        }).start();
    }
}

class Coins extends pickUpObject {

    Image coin; 

    public Coins(int x, int y) throws MalformedURLException, IOException{
        super(x, y);
        super.x = x;
        super.y = y;
        coin = ImageIO.read(new URL("http://dl.dropbox.com/u/47632315/coin.png"));
    }

    public void paint(Graphics g, ImageObserver o){
        g.drawImage(coin, x, y, o);
    }
}

abstract class pickUpObject {

    int x, y;

    public pickUpObject(int x, int y){
    }

    public abstract void paint(Graphics g, ImageObserver o);
}