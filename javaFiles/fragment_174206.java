import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Bubble object for implementing some animations for each block of LOVE pieces
 */
class Bubble extends JLabel {
    private static final long serialVersionUID = 1L;

    boolean isBubbling = false;

    int xpos;
    int ypos;
    float transparency;
    String text = "+100";

    AlphaComposite transparency05 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);

    Bubble(int x, int y) {
        isBubbling = false;
        this.xpos = x;
        this.ypos = y;
    }

    void Bubbling() {
        isBubbling = true;
        for (int i = 1; i <= 50; i += 4) {
            System.out.println("Bubbling init");
            ypos--;
            transparency = transparency / 2;
            setFont(new Font("Arial", Font.BOLD | Font.ITALIC, i));
            repaint();
            try {
                Thread.sleep(50);
            } catch (Throwable e) {
            }
        }

        new Thread() {
            @Override
            public void run() {
                for (int i = 50; i >= 0; i -= 4) {
                    System.out.println("Bubbling run");
                    ypos--;
                    transparency = transparency / 2;
                    setFont(new Font("Arial", Font.BOLD | Font.ITALIC, i));
                    repaint();
                    try {
                        Thread.sleep(50);
                    } catch (Throwable e) {
                    }
                }
                isBubbling = false;
                repaint();
            }
        }.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(180, 50);
    }

    @Override
    protected void paintComponent(Graphics g1) {
        super.paintComponent(g1);

        if (isBubbling) {
            System.out.println("Bubbling paint");

            Graphics2D g = (Graphics2D) g1;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            FontMetrics fm = g.getFontMetrics();
            Rectangle r = getBounds();

            int width = fm.stringWidth(text);
            int height = fm.getHeight() * 4 / 5;
            int cx = g.getFont().getSize() / 10;
            int x = (r.width - width) / 2;
            int xx = fm.charWidth('i');

            // g.setComposite(transparency05);
            // g.setComposite(AlphaComposite.SrcOver);
            g.setColor(Color.red);
            // g.drawString(text,xpos*config.pieceWidth,ypos*config.pieceHeight);
            System.err.println(xpos + " " + ypos);
            g.drawString(text, xpos, ypos);

            // Image img=Tetris.getResource().getImage(config.imagePath+config.imagePrefix+"heart"+config.imagePostfix);
            // g.drawImage(img,img.getWidth(null)+3,0,null);
            // g.drawImage(img,xpos*config.pieceWidth,ypos*config.pieceHeight,null);
        }
    }

    // for test
    static public void main(String[] args) {
        // Create and set up the window.
        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        JPanel newContentPane = new JPanel(new FlowLayout());
        newContentPane.setOpaque(true); // content panes must be opaque
        Bubble bub = new Bubble(50, 50);
        newContentPane.add(bub);

        frame.setContentPane(newContentPane);
        frame.setPreferredSize(new Dimension(300, 300));

        // Display the window.
        frame.pack();
        frame.setVisible(true);

        bub.Bubbling();
    }

}