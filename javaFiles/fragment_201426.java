import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class NerdGirl extends JPanel {
    private static final int SPRITE_ROWS = 5;
    private static final int SPRITE_COLUMNS = 2;
    private static final int DELAY = 150;

    private int DIM_W;
    private int DIM_H;

    private int x1Src;
    private int y1Src;
    private int x2Src;
    private int y2Src;

    private BufferedImage img;

    public NerdGirl() {
        try {
            img = ImageIO.read(getClass().getResource("/resources/nerd-girl.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(NerdGirl.class.getName()).log(Level.SEVERE, null, ex);
        }
        DIM_W = img.getWidth() / SPRITE_ROWS;
        DIM_H = img.getHeight() / SPRITE_COLUMNS;
        x1Src = 0;
        y1Src = 0;
        x2Src = x1Src + DIM_W;
        y2Src = y1Src + DIM_H;
        Timer timer = new Timer(DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (x1Src >= img.getWidth() - DIM_H - 5) {  // 5 to take care of precision loss
                    x1Src = 0;
                    x2Src = x1Src + DIM_W;
                    if (y1Src >= DIM_H - 5) { // 5 to take care of precision loss
                        y1Src = 0;
                        y2Src = y1Src + DIM_H;
                    } else {
                        y1Src += DIM_H;
                        y2Src = y1Src + DIM_H;
                    }

                } else {
                    x1Src += DIM_W;
                    x2Src = x1Src + DIM_W;
                }

                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), x1Src, y1Src, x2Src, y2Src, this);
    }

    @Override
    public Dimension getPreferredSize() {
        return (img == null) ? new Dimension(300, 300) : new Dimension(DIM_W, DIM_H);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new NerdGirl());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}