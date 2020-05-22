import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Pucca extends Applet {

    public Pucca() {
        setSize(700, 700);
        Thread t = new Thread(new Runnable() {
            private int xDelta = -1;
            private int yDelta = 0;
            private int blinkCount = 0;

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException ex) {
                    }

                    xOffset += xDelta;
                    double irisSize = eyeSize.width * irisScale;
                    double range = ((eyeSize.width - irisSize) / 2);
                    if (xOffset <= -range) {
                        xOffset = -(int) range;
                        xDelta *= -1;
                    } else if (xOffset >= range) {
                        xOffset = (int) range;
                        xDelta *= -1;
                    }
                    blinkCount++;
                    if (blink && blinkCount > 10) {
                        blink = false;
                        blinkCount = 0;
                    } else if (blinkCount > 25) {
                        blink = true;
                        blinkCount = 0;
                    }
                    repaint();
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private boolean blink = false;

    private int xOffset, yOffset = 0;
    private Dimension eyeSize = new Dimension(125, 125);
    private Point left = new Point(20, 20);
    private Point right = new Point(left.x + 100, left.y);
    private double irisScale = 0.4;
    private double pupilScale = 0.16;

//paint method
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        paintEye(g, new Rectangle(left, eyeSize));
        paintEye(g, new Rectangle(right, eyeSize));

    }

    protected void paintEye(Graphics g, Rectangle bounds) {

        Color white = new Color(255, 255, 255);

        if (blink) {
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(white);
        }
        g.fillOval(bounds.x, bounds.y, bounds.width, bounds.height); //left white fill eye

        g.setColor(Color.BLACK);
        g.drawOval(bounds.x, bounds.y, bounds.width, bounds.height); // left big black line eye

        if (!blink) {
            Color blue = new Color(0, 160, 198);

            paintEyePartAt(g, bounds, irisScale, blue);
            paintEyePartAt(g, bounds, pupilScale, Color.BLACK);
        }
    }

    private void paintEyePartAt(Graphics g, Rectangle bounds, double delta, Color color) {

        int width = (int) (bounds.width * delta);
        int height = (int) (bounds.height * delta);

        g.setColor(color);
        g.fillOval(
                xOffset + bounds.x + ((bounds.width - width) / 2),
                yOffset + bounds.y + ((bounds.height - height) / 2),
                width, height); // left blue fill eye
        g.setColor(Color.BLACK);
        g.drawOval(
                xOffset + bounds.x + ((bounds.width - width) / 2),
                yOffset + bounds.y + ((bounds.height - height) / 2),
                width,
                height); // left blue fill eye
    }
}