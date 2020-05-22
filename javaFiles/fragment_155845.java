import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jdesktop.jxlayer.JXLayer;
import org.jdesktop.jxlayer.QualityHints;
import org.jdesktop.jxlayer.plaf.AbstractBufferedLayerUI;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                SelectablePane pane = new SelectablePane();
                SelectableUI ui = new SelectableUI();
                JXLayer<JPanel> layer = new JXLayer<>(pane, ui);
                layer.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ui.setSelected(!ui.isSelected());
                    }

                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(layer);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class SelectablePane extends JPanel {

        public SelectablePane() {

            setLayout(new GridBagLayout());
            add(new JLabel("Hello world"));

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

    public static class SelectableUI extends AbstractBufferedLayerUI<JPanel> {

        public static Map<RenderingHints.Key, Object> mapRenderHints = new QualityHints();

        private boolean selected = false;

        public SelectableUI() {

            mapRenderHints.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY); // okay
            mapRenderHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // bad
            mapRenderHints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY); // okay
            mapRenderHints.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            mapRenderHints.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            mapRenderHints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            mapRenderHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        }

        public void setSelected(boolean value) {

            if (selected != value) {
                selected = value;
                firePropertyChange("selected", !selected, selected);
                repaint();
            }

        }

        public boolean isSelected() {
            return selected;
        }

        @Override
        protected void paintLayer(Graphics2D g2, JXLayer<? extends JPanel> l) {
            super.paintLayer(g2, l);
            if (isSelected()) {
                Graphics2D g2d = (Graphics2D) g2.create();
                g2d.setColor(UIManager.getColor("List.selectionBackground"));
                g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
                g2d.fillRect(0, 0, l.getWidth(), l.getHeight());
                g2d.dispose();
            }
        }

        @Override
        protected Map<RenderingHints.Key, Object> getRenderingHints(JXLayer<? extends JPanel> l) {
            return mapRenderHints;
        }

        public void repaint() {
            setDirty(true);
        }

        public void invalidate() {
            setDirty(true);
        }

        public void revalidate() {
            setDirty(true);
        }
    }

}