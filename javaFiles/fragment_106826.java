import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import edu.umd.cs.piccolo.PCanvas;
import edu.umd.cs.piccolo.PLayer;
import edu.umd.cs.piccolo.PNode;
import edu.umd.cs.piccolo.event.PBasicInputEventHandler;
import edu.umd.cs.piccolo.event.PInputEvent;
import edu.umd.cs.piccolo.nodes.PPath;
import edu.umd.cs.piccolo.util.PBounds;

public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {   
            public void run() {   
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);

                final PCanvas canvas = new PCanvas() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(600, 400);
                    }
                };

                PLayer layer = new PLayer() {
                    @Override
                    public void addChild(final PNode child) {
                        System.out.println("notify: addChild");
                        super.addChild(child);
                    }
                };

                canvas.getCamera().addLayer(0, layer);
                canvas.getCamera().getRoot().addChild(layer);

                final PPath node = PPath.createRectangle(0, 0, 100, 100);
                node.setPaint(Color.RED);
                canvas.getLayer().addChild(node);

                canvas.addInputEventListener(new PBasicInputEventHandler() {
                    @Override
                    public void mouseClicked(PInputEvent event) {
                        Point2D p = event.getCamera().localToView(
                                event.getCanvasPosition());
                        PBounds bounds = node.getBounds();
                        final double dx = p.getX() - bounds.getCenterX();
                        final double dy = p.getY() - bounds.getCenterY();
                        node.animateToBounds(node.getBounds().x + dx, bounds.y
                                + dy, bounds.width, bounds.height, 300);
                    }
                });

                frame.add(canvas);            
                frame.pack();
                frame.setVisible(true);
            }
        });
    }    
}