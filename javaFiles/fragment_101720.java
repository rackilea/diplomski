import java.awt.Color;
import edu.umd.cs.piccolo.nodes.PPath;
import edu.umd.cs.piccolox.PFrame;

public class SimpleEllipseNode {
    public static void main(final String[] args) {
        PFrame frame = new PFrame() {
            @Override
            public void initialize() {
                final PPath circle = PPath.createEllipse(0, 0, 100, 100);
                circle.setPaint(Color.RED);
                getCanvas().getLayer().addChild(circle);
            }
        };
    }
}