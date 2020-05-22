import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class DrawRect2 extends JPanel {
    public static final String IMG_PATH = "https://previews.123rf.com/images/victoroancea"
            + "/victoroancea1201/victoroancea120100059"
            + "/12055848-tv-color-test-pattern-test-card-for-pal-and-ntsc.jpg";
    private static final int PREF_W = 600;
    private static final int PREF_H = PREF_W;
    private DrawingPanel drawingPanel;

    public DrawRect2(Image img) {
        drawingPanel = new DrawingPanel(img);
        JScrollPane scrollPane = new JScrollPane(drawingPanel);
        MyMouse myMouse = new MyMouse();
        drawingPanel.addMouseListener(myMouse);
        drawingPanel.addMouseMotionListener(myMouse);

        setLayout(new BorderLayout());
        add(scrollPane);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        Image img = null;
        try {
            URL url = new URL(IMG_PATH);
            img = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        DrawRect2 mainPanel = new DrawRect2(img);

        JFrame frame = new JFrame("DrawRect2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

}