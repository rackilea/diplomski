import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final JPanel panel = new JPanel() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(600, 300);
                    }

                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponents(g);
                        final Graphics2D g2d = (Graphics2D) g.create();

                        try {
                            GeneralPath body, mirror;

                            body = new GeneralPath();
                            mirror = new GeneralPath();

                            body.moveTo(205.5, 97);
                            body.lineTo(207, 132);
                            body.quadTo(193, 105, 197, 80);
                            body.curveTo(188, 98, 156, 127, 159, 167);
                            body.quadTo(163, 174, 166, 184);
                            body.curveTo(173, 196, 193, 210, 213, 208);
                            body.curveTo(247, 208, 267, 196, 274, 184);

                            g2d.setPaint(new Color(255, 251, 223));
                            g2d.fill(body);
                            g2d.setPaint(Color.black);
                            g2d.draw(body);

                            AffineTransform tx = AffineTransform
                                    .getScaleInstance(-1, 1);
                            tx.translate(-274 * 2, 0);
                            g2d.transform(tx);

                            g2d.setPaint(Color.YELLOW);
                            g2d.fill(body);
                            g2d.setPaint(Color.BLACK);
                            g2d.draw(body);
                        } finally {
                            g2d.dispose();
                        }
                    }
                };
                JOptionPane.showMessageDialog(null, panel, "Mirror", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}