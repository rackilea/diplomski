import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Painter;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.nimbus.AbstractRegionPainter;

public class TestTextField {

    public static void main(String[] args) {
        new TestTextField();
    }

    public TestTextField() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
//                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }


                JTextField field = new JTextField("Hello", 10);
                field.setEditable(false);
                field.setEnabled(false);
                UIDefaults overrides = new UIDefaults();
                overrides.put("TextField.background", new ColorUIResource(Color.RED));
                overrides.put("TextField[Enabled].backgroundPainter", new Painter<JTextField>() {

                    @Override
                    public void paint(Graphics2D g, JTextField field, int width, int height) {
                        g.setColor(Color.RED);
                        g.fill(new Rectangle(0, 0, width, height));
                    }

                });
                overrides.put("TextField[Disabled].backgroundPainter", new Painter<JTextField>() {

                    @Override
                    public void paint(Graphics2D g, JTextField field, int width, int height) {
                        g.setColor(Color.GREEN);
                        Insets insets = field.getInsets();
                        g.fill(new Rectangle(
                                insets.left, 
                                insets.top, 
                                width - (insets.left + insets.right), 
                                height - (insets.top + insets.bottom)));
                    }

                });
                field.putClientProperty("Nimbus.Overrides", overrides);
//                field.putClientProperty("Nimbus.Overrides.InheritDefaults",false);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new FlowLayout());
                frame.add(field);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}