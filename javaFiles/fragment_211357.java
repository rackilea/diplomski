import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.plaf.LayerUI;

public class Example {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }

    public Example() {
        JFrame frame = new JFrame("Example");

        JPanel panel1 = new JPanel();
        panel1.add(new JButton("Panel 1"));
        MyLayerUI layerUI = new MyLayerUI();
        JLayer<JPanel> panel1Layer = new JLayer<JPanel>(panel1, layerUI);
        panel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (layerUI.hasOverlay()) {
                    layerUI.setOverlay(false);
                } else {
                    layerUI.setOverlay(true);
                }
                panel1Layer.repaint();
            }
        });

        JPanel panel2 = new JPanel();
        panel2.add(new JButton("Panel 2"));

        JPanel contentPane = new JPanel(new GridLayout(2, 1));
        contentPane.add(panel1Layer);
        contentPane.add(panel2);

        frame.setContentPane(contentPane);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

class MyLayerUI extends LayerUI<JPanel> {
    private boolean overlay = true;

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        if (hasOverlay()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(new Color(0, 100, 0, 100));
            g2.fillRect(0, 0, c.getWidth(), c.getHeight());
            g2.dispose();
        }
    }

    public boolean hasOverlay() {
        return overlay;
    }

    public void setOverlay(boolean overlay) {
        this.overlay = overlay;
    }
}