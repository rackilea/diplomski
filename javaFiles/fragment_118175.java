import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

// <applet code=TutoringCalculator width=400 height=400></applet>
public class TutoringCalculator extends JApplet {

    // The size of an applet is set by the HTML!
    //private static final int JFXPANEL_WIDTH_INT = 300;
    //private static final int JFXPANEL_HEIGHT_INT = 250;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Tutoring Calculator");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JApplet applet = new TutoringCalculator();
                applet.init();

                frame.setContentPane(applet.getContentPane());

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                applet.start();
            }
        });
    }

    private JPanel swingContainer;

    @Override
    public void init() {
        swingContainer = new JPanel(new BorderLayout());
        add(swingContainer, BorderLayout.CENTER);
        createScene();
    }

    private void createScene() {
        JButton btn = new JButton();
        btn.setText("Say 'Hello World'");
        JRootPane root = new JRootPane();
        root.getContentPane().add(btn);
        swingContainer.add(root);
    }
}