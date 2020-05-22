import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.*;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class MoveBall {
    private static final int PREF_W = 500;
    private static final int PREF_H = PREF_W;

    private static void createAndShowGui() {
        BallPanel ballPanel = new BallPanel(PREF_W, PREF_H);
        MyMouse myMouse = new MyMouse(ballPanel);
        ballPanel.addMouseListener(myMouse);
        ballPanel.addMouseMotionListener(myMouse);
        new CreateKeyBindings(ballPanel);


        JFrame frame = new JFrame("MoveBall");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(ballPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
}

@SuppressWarnings("serial")
class BallPanel extends JPanel {

    private static final Color ELLIPSE_COLOR = Color.RED;
    private static final Color SQUARE_COLOR = Color.GREEN;
    private static final int BALL_WIDTH = 40;
    private int prefW;
    private int prefH;
    private boolean isEllipse = true;
    private int ballX;
    private int ballY;

    public BallPanel(int prefW, int prefH) {
        this.prefW = prefW;
        this.prefH = prefH;
    }

    public boolean isEllipse() {
        return isEllipse;
    }

    public void setEllipse(boolean isEllipse) {
        this.isEllipse = isEllipse;
    }

    public int getBallX() {
        return ballX;
    }

    public void setBallX(int ballX) {
        this.ballX = ballX;
    }

    public void setXY(int x, int y) {
        ballX = x;
        ballY = y;
        repaint();
    }

    public void setXYCenter(int x, int y) {
        ballX = x - BALL_WIDTH / 2;
        ballY = y - BALL_WIDTH / 2;
        repaint();
    }

    public void setXYCenter(Point p) {
        setXYCenter(p.x, p.y);
    }

    public int getBallY() {
        return ballY;
    }

    public void setBallY(int ballY) {
        this.ballY = ballY;
    }

    public void incrementBallX(int x) {
        ballX += x;
        repaint();
    }

    public void incrementBallY(int y) {
        ballY += y;
        repaint();
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (isEllipse) {
            g2.setColor(ELLIPSE_COLOR);
            g2.fillOval(ballX, ballY, BALL_WIDTH, BALL_WIDTH);
        } else {
            g2.setColor(SQUARE_COLOR);
            g2.fillOval(ballX, ballY, BALL_WIDTH, BALL_WIDTH);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(prefW, prefH);
    }
}

class MyMouse extends MouseAdapter {

    private BallPanel ballPanel;

    public MyMouse(BallPanel ballPanel) {
        this.ballPanel = ballPanel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ballPanel.setXYCenter(e.getPoint());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        ballPanel.setXYCenter(e.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ballPanel.setXYCenter(e.getPoint());
    }

}

enum Direction {
    UP(KeyEvent.VK_UP), DOWN(KeyEvent.VK_DOWN), LEFT(KeyEvent.VK_LEFT), RIGHT(KeyEvent.VK_RIGHT);

    private int key;

    private Direction(int key) {
       this.key = key;
    }

    public int getKey() {
       return key;
    }
 }

 // Actions for the key binding
 @SuppressWarnings("serial")
 class MyKeyAction extends AbstractAction {
    private static final int STEP_DISTANCE = 5;
    private BallPanel ballPanel;
    private Direction direction;

    public MyKeyAction(BallPanel ballPanel, Direction direction) {
       this.ballPanel = ballPanel;
       this.direction = direction;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       switch (direction) {
       case UP:
          ballPanel.incrementBallY(-STEP_DISTANCE);
          break;
       case DOWN:
           ballPanel.incrementBallY(STEP_DISTANCE);
          break;
       case LEFT:
           ballPanel.incrementBallX(-STEP_DISTANCE);
          break;
       case RIGHT:
           ballPanel.incrementBallX(STEP_DISTANCE);
          break;

       default:
          break;
       }
    }
 }

class CreateKeyBindings {

    private BallPanel ballPanel;

    public CreateKeyBindings(BallPanel ballPanel) {
        this.ballPanel = ballPanel;
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = ballPanel.getInputMap(condition);
        ActionMap actionMap = ballPanel.getActionMap();

        for (Direction direction : Direction.values()) {
            KeyStroke keyStroke = KeyStroke.getKeyStroke(direction.getKey(), 0);
            String keyString = keyStroke.toString();
            inputMap.put(keyStroke, keyString);
            actionMap.put(keyString, new MyKeyAction(ballPanel, direction));
        }
    }

}