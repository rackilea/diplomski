import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.tools.Tool;

public class AnimationEngine {

    public static void main(String[] args) {
        new AnimationEngine();
    }

    public AnimationEngine() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new Board(40));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class Board extends JPanel implements Runnable {

        protected static final Object UPDATE = new Object();
        private static final int NO_DELAYS_PER_YIELD = 16;
        /* Number of frames with a delay of 0 ms before the
         animation thread yields to other running threads. */
        private static int MAX_FRAME_SKIPS = 5;
// no. of frames that can be skipped in any one animation loop
// i.e the games state is updated but not rendered
        private Thread animator;
        int x, y;
        final int frameCount = 8;
        BufferedImage flowers;
        private int[][] fPos = {{232, 15}, {400, 200}, {335, 335}}; // flower coordinates 
        private static int bWIDTH = 500; // width of window 
        private static int bHEIGHT = 400;// height of window
        private Font font;
        private FontMetrics metrics;
//        private House house = new House();
//        private Flower flower = new Flower();
        private Player girlP = new Player();
        private int px = 200;
        private int py = 400;
        private long period;
        private volatile boolean running = false;
        private volatile boolean gameOver = false;
        private volatile boolean isPaused = false;
//        private Graphics dbg;
        private BufferedImage activeBuffer = null;
        private BufferedImage scratchBuffer = null;

        public Board(long period) {

            this.period = period;

            setBackground(Color.white);
            setPreferredSize(new Dimension(bWIDTH, bHEIGHT));

            setFocusable(true);
            requestFocus();     //JPanel now receives key events
            readyForTermination();

            // create game components

            // listen for mouse presses
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    System.out.println("Clicked");
                    girlP.setDestination(e.getX(), e.getY());
                }
            });

            // set up message font
            font = new Font("SansSerif", Font.BOLD, 24);
            metrics = this.getFontMetrics(font);

            x = 15;
            y = 150;
        }   // end of 'Board()'

        public void addNotify() {
            super.addNotify();
            startGame();
        }

        public void startGame() {
            if (animator == null || !running) {
                animator = new Thread(this);
                animator.start();
            }
        }

        public void pauseGame() {
            isPaused = true;
        }

        public void resumeGame() {
            isPaused = false;
        }

        public void stopGame() {
            running = false;
        }

        private void readyForTermination() {
            addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {

                    // listen for escape, q, or ctrl-c
                    int keyCode = e.getKeyCode();
                    if ((keyCode == KeyEvent.VK_ESCAPE)
                                    || (keyCode == KeyEvent.VK_Q)
                                    || (keyCode == KeyEvent.VK_END)
                                    || ((keyCode == KeyEvent.VK_C) && e.isControlDown())) {
                        running = false;
                    }
                }
            });
        }

        @Override
        public void invalidate() {
            synchronized (UPDATE) {
                activeBuffer = null;
                scratchBuffer = null;
            }
            super.invalidate();
        }

        private void gameRender() {
            synchronized (UPDATE) {
                if (getWidth() > 0 && getHeight() > 0) {
                    if (scratchBuffer == null) {
                        scratchBuffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                    }

                    Graphics2D dbg = scratchBuffer.createGraphics();

                    // clearing the background
                    dbg.setColor(Color.GRAY);
                    dbg.fillRect(0, 0, scratchBuffer.getWidth(), scratchBuffer.getHeight());

                    dbg.setColor(Color.blue);
                    dbg.setFont(font);


                    //drawing game elements....
                    girlP.draw(dbg, this);

                    if (gameOver) {
                        gameOverMessage(dbg);
                    } // end of gameRender()
                    dbg.dispose();
                }

                BufferedImage tmp = activeBuffer;
                activeBuffer = scratchBuffer;
                scratchBuffer = tmp;
            }
        }

        private void gameUpdate() {
            if (!isPaused && !gameOver) {
                girlP.move();
            }
        }

        private void gameOverMessage(Graphics g) // center the game-over message
        { // code to calculate x and y...
            String msg = "Game Over";
            g.drawString(msg, x, y);
        }  // end of gameOverMessage( )

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (activeBuffer != null) {
                g.drawImage(activeBuffer, 0, 0, null);
            }
        }

        public void run() {

            long beforeTime, afterTime, timeDiff, sleep;
            beforeTime = System.currentTimeMillis();

            running = true;
            while (running) {
                gameUpdate();
                gameRender();

                repaint();

                afterTime = System.currentTimeMillis();
                timeDiff = afterTime - beforeTime;
                sleep = (period - timeDiff); // - overSleepTime; // time left in this loop

                if (sleep > 0) { // some time left in this cycle
                    try {
                        Thread.sleep(sleep); // nano -> ms
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted");
                    }
                } else {      // sleep <= 0; frame took longer than the delay
                    System.out.println("Over...");
                }

                beforeTime = System.currentTimeMillis();
            }
            System.exit(0);
        } // end of run();
    }

    public static class Player {

        double positionX;
        double positionY;
        int destinationX;//Used when moving from place to place
        int destinationY;
        Tool currentTool;
        int direction; //Position the image is facing
        int dx;
        int dy;
        private String girl = "/Player01.png";
        ImageIcon ii = new ImageIcon(this.getClass().getResource(girl));
        private Image image = ii.getImage();
        private boolean visible = true;
        Image playerImage;

        public Player() {
            positionX = 30;
            positionY = 20;
            dx = 4;
            dy = 4;
            destinationX = (int) positionX;
            destinationY = (int) positionY;

            //this.playerImage=playerImage;
        }

        public void doAction() {
            //currentTool.getNum();
        }

        public boolean isVisible() {
            return visible;
        }

        public void setVisible(Boolean visible) {
            this.visible = visible;
        }

        public Image getImage() {
            return image;
        }

        public void move() {
            if (destinationX != positionX || destinationY != positionY) {
                //MOVE LEFT AND RIGHT
                if (destinationX < positionX) {
                    positionX -= dx;
                }
                if (destinationX > positionX) {
                    positionX += dx;
                }

                //MOVE UP AND DOWN
                if (destinationY < positionY) {
                    positionY -= dy;
                }
                if (destinationY > positionY) {
                    positionY += dy;
                }
            }
        }

        public void setDestination(int x, int y) {
            destinationX = x;
            destinationY = y;
        }

        public void draw(Graphics g, ImageObserver io) {
            g.drawImage(image, (int) positionX, (int) positionY, io);
        }
    }
}