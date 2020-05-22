package stackgame;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StackGame extends JApplet {
    private final static int BOX_SIZE = 15;
    private final static int ROWS = 30;
    private final static int COLS = 15;

    private static int currentRow = 1;
    private static int currentCount = 9;
    private static JFrame f = new JFrame();

    private static JPanel gamePanel = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, COLS * BOX_SIZE, (ROWS + 1) * BOX_SIZE);

            g.setColor(Color.BLUE);
            for (int j = 0 ; j < ROWS ; j++) {
                for (int i = 0 ; i < COLS ; i++) {
                    if (boxes[i][j]) {
                        g.fillRect(
                                (i * BOX_SIZE) + 1,
                                (ROWS * BOX_SIZE) - (j * BOX_SIZE) + 1,
                                BOX_SIZE - 2,
                                BOX_SIZE - 2);
                    }
                }
            }
        }
    };

    private static long sleepTime = 500;

    private static Thread moveBoxesThread = new Thread() {
        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(sleepTime );
                }
                catch (InterruptedException e) {
                    break;
                }
                moveRow();
                gamePanel.repaint();
            }
        }
    };

    static boolean[][] boxes = new boolean[COLS][ROWS];
    static {
        for (int i = 0 ; i < COLS ; i++) {
            for (int j = 0 ; j < ROWS ; j++) {
                boxes[i][j] = false;
            }
        }
        moveBoxesThread.setDaemon(true);
    }

    private static boolean movingRight = true;

    private static void startGame() {
        for (int i = 3 ; i < 12 ; i++) {
            boxes[i][0] = true;
        }

        initRow();

        gamePanel.repaint();
        startKeyListenning();
        moveBoxesThread.start();
    }

    private static void initRow() {
        if (currentRow >= ROWS) {
            moveBoxesThread.interrupt();
            JOptionPane.showMessageDialog(f, "You win, StackOverFlow!");
            System.exit(0);
        }
        for (int i = 0 ; i < currentCount ; i++) {
            boxes[i][currentRow] = true;
        }
    }

    private static void startKeyListenning() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
            new KeyEventDispatcher() {

                @Override
                public boolean dispatchKeyEvent(KeyEvent e) {
                    if (!f.isFocusOwner() || currentRow > ROWS - 1)
                        return false;
                    if (e.getID() == KeyEvent.KEY_PRESSED
                            && e.getKeyCode() == KeyEvent.VK_SPACE) {
                        checkRowAndProceed();
                    }
                    return false;
                }
        });
    }

    protected static synchronized void checkRowAndProceed() {
        int count = 0;
        for (int i = 0 ; i < COLS ; i++) {
            try {
                if (!boxes[i][currentRow - 1]) {
                    boxes[i][currentRow] = false;
                }
                if (boxes[i][currentRow]) {
                    count++;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        currentCount = count;
        if (currentCount == 0) {
            JOptionPane.showMessageDialog(f, "You loose!");
            System.exit(0);
        }
        currentRow++;
        movingRight  = true;
        initRow();
        sleepTime *= 95;
        sleepTime /= 100;
    }

    protected static synchronized void moveRow() {
        if (!movingRight) {
            for (int col = 0 ; col < COLS - 1 ; col++) {
                boxes[col][currentRow] = boxes[col + 1][currentRow];
            }
            boxes[COLS - 1][currentRow] = false;
        }
        else {
            for (int col = COLS - 1 ; col > 0 ; col--) {
                boxes[col][currentRow] = boxes[col - 1][currentRow];
            }
            boxes[0][currentRow] = false;
        }
        if ((movingRight && boxes[COLS - 1][currentRow])
                || (!movingRight && boxes[0][currentRow])) {
            movingRight = !movingRight;
        }
    }

    public static void main(String[] args) {
        try {
            gamePanel.setPreferredSize(new Dimension(COLS * BOX_SIZE, (ROWS + 1) * BOX_SIZE));
            f.getContentPane().add(gamePanel);
            f.pack();
            f.setResizable(false);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLocationRelativeTo(null);
            f.setVisible(true);

            startGame();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}