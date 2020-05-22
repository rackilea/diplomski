import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Painter;
import javax.swing.UIManager;

public class NimbusTest3 {

    private static final long serialVersionUID = 1L;
    private JFrame frame = new JFrame();
    private JButton button = new JButton("Text");
    private JTextField label = new JTextField("Text");
    private JTextField label1 = new JTextField("Text");

    public NimbusTest3() {
        label.setEnabled(false);
        frame.add(button);
        frame.add(label, BorderLayout.NORTH);
        frame.add(label1, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(laf.getName())) {
                    UIManager.setLookAndFeel(laf.getClassName());
                    UIManager.getLookAndFeelDefaults().put("TextField[Disabled].backgroundPainter",
                            new FillPainterUI(new Color(127, 255, 191)));
                    UIManager.getLookAndFeelDefaults().put("TextField[Disabled].textForeground", new Color(255, 0, 0));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                NimbusTest3 nimbusTest3 = new NimbusTest3();
            }
        });
    }

    static class FillPainterUI implements Painter<JComponent> {
        // fills whole, available area, ignoring rounded corners, Borders e.i.
        private final Color color;

        FillPainterUI(Color c) {
            color = c;
        }

        @Override
        public void paint(Graphics2D g, JComponent object, int width, int height) {
            g.setColor(color);
            g.fillRect(0, 0, width - 1, height - 1);
        }
    }
}