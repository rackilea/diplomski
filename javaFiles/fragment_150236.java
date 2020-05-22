import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.ui.OverlayLayout;

public class SIView implements Runnable {

    public static interface SIParams {

        int RES_X = 500;
        int RES_Y = 400;
    }

    public static class GamePanel extends JPanel {
        public GamePanel() {
            setBackground(new Color(0, 0, 0));
            setLayout(new OverlayLayout());
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(SIParams.RES_X, SIParams.RES_Y);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }

        // some code not related
    }

    private JFrame mainFrame;
    private GamePanel gamePanel;

    @Override
    public void run() {
        mainFrame = createMainFrame();
        gamePanel = new GamePanel();
        mainFrame.getContentPane().add(gamePanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private JFrame createMainFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Space Intruders");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    public void init() {
        SwingUtilities.invokeLater(this);

    }

    // some code not related

    public static void main(String[] args) {
        new SIView().init();
    }

}