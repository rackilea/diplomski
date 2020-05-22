import java.awt.*;
import javax.swing.*;

public class TerrisView {

    public JComponent canvas;

    public TerrisView(String title) {
        // Don't extend frame, just use one
        JFrame f = new JFrame(title);
        canvas = new JComponent() {
            @Override // check this is a real method
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                // paint the BG - automatic for a JPanel
                g.setColor(getBackground());
                g.fillRect(0,0,getWidth(),getHeight());

                g.setColor(Color.BLACK);
                // make it dynamic, changing with the size
                int pad = 10;
                g.fillRect(pad, pad, getWidth()-(2*pad), getHeight()-(2*pad));
            }
        };
        // layout managers are more likely to respect the preferred size
        canvas.setPreferredSize(new Dimension(300, 400));
        canvas.setBackground(Color.ORANGE);
        f.add(canvas, BorderLayout.CENTER);
        f.pack();
        // nice tweak
        f.setMinimumSize(f.getSize());
        // see http://stackoverflow.com/a/7143398/418556
        f.setLocationByPlatform(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        // start/alter Swing GUIs on the EDT
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TerrisView("Terris View");
            }
        });
    }
}