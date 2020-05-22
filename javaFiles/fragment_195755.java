import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestGC {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                GraphicsDevice[] sds = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
                for (GraphicsDevice sd : sds) {
                    System.out.println(sd.getIDstring());
                    GraphicsConfiguration gc = sd.getDefaultConfiguration();
                    JFrame f = new JFrame(gc);
                    f.add(new JLabel(sd.getIDstring()));
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.pack();
                    centerOn(f, gc);
                    f.setVisible(true);
                }
            }
        });
    }

    private static void centerOn(JFrame f, GraphicsConfiguration gc) {
        Rectangle bounds = gc.getBounds();
        int x = bounds.x + ((bounds.width - f.getWidth()) / 2);
        int y = bounds.y + ((bounds.height - f.getHeight()) / 2);
        f.setLocation(x, y);
    }
}