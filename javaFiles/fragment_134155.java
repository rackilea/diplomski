import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {
    private static final long serialVersionUID = -3415101101924291007L;

    int bcx = Game.bx;
    int bcy = Game.by;
    int oc1x = Game.o1x;
    int oc1y = Game.o1y;
    int oc2x = Game.o2x;
    int oc2y = Game.o2y;
    int oc3x = Game.o3x;
    int oc3y = Game.o3y;
    int oc4x = Game.o4x;
    int oc4y = Game.o4y;
    int oc5x = Game.o5x;
    int oc5y = Game.o5y;

    Rectangle rbc, roc1, roc2, roc3, roc4, roc5, rs1, rs2, rs3;

    Image blueCar, orangeCar;

    public GamePanel() {
        super();

        Toolkit t = Toolkit.getDefaultToolkit();
        blueCar = t.getImage(getClass().getClassLoader().getResource("resources/blue_car.png").getPath());
        orangeCar = t.getImage(getClass().getClassLoader().getResource("resources/orange_car.png").getPath());

        addKeyListener(this);
    }

    public void move() {
        // int s=Game.speed;
        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    int s = Game.speed;
                    Random rand = new Random();

                    while (true) {
                        Game.rn1 = rand.nextInt(5) + 1;
                        if ((Game.rn1 != Game.rn2) && (Game.rn1 != Game.rn3) && (Game.rn1 != Game.rn4)
                                && (Game.rn1 != Game.rn5)) {
                            break;
                        }
                    }

                    if (Game.rn1 == 1) {
                        Game.score++;
                        Game.stat = true;
                        oc1y = Game.o1y;
                        while (oc1y < 1000) {
                            oc1y++;
                            repaint();
                            try {
                                Thread.sleep(s);
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                    if (Game.rn1 == 2) {
                        Game.score++;
                        Game.stat = true;
                        oc2y = Game.o2y;
                        while (oc2y < 1000) {
                            oc2y++;
                            repaint();
                            try {
                                Thread.sleep(s);
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                    if (Game.rn1 == 3) {
                        Game.score++;
                        Game.stat = true;
                        oc3y = Game.o3y;
                        while (oc3y < 1000) {
                            oc3y++;
                            repaint();
                            try {
                                Thread.sleep(s);
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                    if (Game.rn1 == 4) {
                        Game.score++;
                        Game.stat = true;
                        oc4y = Game.o4y;
                        while (oc4y < 1000) {
                            oc4y++;
                            repaint();
                            try {
                                Thread.sleep(s);
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                    if (Game.rn1 == 5) {
                        Game.score++;
                        Game.stat = true;
                        oc5y = Game.o5y;
                        while (oc5y < 1000) {
                            oc5y++;
                            repaint();
                            try {
                                Thread.sleep(s);
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                }
            }
        };
        t1.start();
        // t2.start();
        // t3.start();
        // t4.start();
        // t5.start();
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("Key...");
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            bcx = bcx - 10;
        }
        if (key == KeyEvent.VK_RIGHT) {
            bcx = bcx + 10;
        }
        if (key == KeyEvent.VK_UP) {
            bcy = bcy - 10;
        }
        if (key == KeyEvent.VK_DOWN) {
            if (bcy >= 835) {
                bcy = bcy;
            } else {
                bcy = bcy + 10;
            }
        }
    }

    public void keyTyped(KeyEvent e) { }

    public void keyReleased(KeyEvent e) { }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if ((Game.score % 5 == 0) && (Game.speed > 1) && (Game.stat == true)) {
            Game.speed--;
            Game.stat = false;
        }

        rbc = new Rectangle(bcx, bcy, 55, 105);
        roc1 = new Rectangle(oc1x, oc1y, 55, 105);
        roc2 = new Rectangle(oc2x, oc2y, 55, 105);
        roc3 = new Rectangle(oc3x, oc3y, 55, 105);
        roc4 = new Rectangle(oc4x, oc4y, 55, 105);
        roc5 = new Rectangle(oc5x, oc5y, 55, 105);
        rs1 = new Rectangle(275, 70, 451, 30);
        rs2 = new Rectangle(245, 70, 30, 910);
        rs3 = new Rectangle(726, 70, 30, 910);

        if ((rbc.intersects(roc1) == true) || (rbc.intersects(roc2) == true) || (rbc.intersects(roc3) == true)
                || (rbc.intersects(roc4) == true) || (rbc.intersects(roc5) == true) || (rbc.intersects(rs1) == true)
                || (rbc.intersects(rs2) == true) || (rbc.intersects(rs3) == true)) {
            System.out.println("Collision");
            System.out.println("Score: " + Game.score);
            System.out.println("Speed: " + Game.speed);
            System.exit(0);
        }

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1000, 1000);
        g.setColor(Color.BLACK);
        g.drawRect(275, 100, 450, 850);
        g.drawRect(365, 100, 90, 850);
        g.drawRect(545, 100, 90, 850);

        if ((Game.rn1 == 1) || (Game.rn2 == 1) || (Game.rn3 == 1) || (Game.rn4 == 1) || (Game.rn5 == 1)) {
            g.drawImage(orangeCar, oc1x, oc1y, this);
        }
        if ((Game.rn1 == 2) || (Game.rn2 == 2) || (Game.rn3 == 2) || (Game.rn4 == 2) || (Game.rn5 == 2)) {
            g.drawImage(orangeCar, oc2x, oc2y, this);
        }
        if ((Game.rn1 == 3) || (Game.rn2 == 3) || (Game.rn3 == 3) || (Game.rn4 == 3) || (Game.rn5 == 3)) {
            g.drawImage(orangeCar, oc3x, oc3y, this);
        }
        if ((Game.rn1 == 4) || (Game.rn2 == 4) || (Game.rn3 == 4) || (Game.rn4 == 4) || (Game.rn5 == 4)) {
            g.drawImage(orangeCar, oc4x, oc4y, this);
        }
        if ((Game.rn1 == 5) || (Game.rn2 == 5) || (Game.rn3 == 5) || (Game.rn4 == 5) || (Game.rn5 == 5)) {
            g.drawImage(orangeCar, oc5x, oc5y, this);
        }

        g.drawImage(blueCar, bcx, bcy, this);

        g.setColor(Color.BLACK);
        g.fillRect(275, 70, 451, 30);
        g.fillRect(275, 950, 451, 30);
        g.fillRect(245, 70, 30, 910);
        g.fillRect(726, 70, 30, 910);

        g.setColor(Color.WHITE);
        g.fillRect(275, 980, 451, 100);
        g.fillRect(275, 0, 451, 69);

        g.setColor(Color.BLACK);
        g.drawString("Score: " + Game.score, 50, 50);
    }
}