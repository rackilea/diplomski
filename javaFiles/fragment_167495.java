import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestJLayeredPane {

    public static class AbsoluteLayoutManager implements LayoutManager {

        private Map<Component, Rectangle> bounds = new LinkedHashMap<Component, Rectangle>();

        @Override
        public void addLayoutComponent(String name, Component comp) {
            bounds.put(comp, new Rectangle(comp.getPreferredSize()));
        }

        @Override
        public void removeLayoutComponent(Component comp) {
            bounds.remove(comp);
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            Rectangle rect = new Rectangle();
            for (Rectangle r : bounds.values()) {
                rect = rect.union(r);
            }
            return rect.getSize();
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return preferredLayoutSize(parent);
        }

        @Override
        public void layoutContainer(Container parent) {
            for (Entry<Component, Rectangle> e : bounds.entrySet()) {
                e.getKey().setBounds(e.getValue());
            }
        }

        public void setBounds(Component c, Rectangle bounds) {
            this.bounds.put(c, bounds);
        }
    }

    protected void initUI() {
        JFrame frame = new JFrame("test");
        AbsoluteLayoutManager layout = new AbsoluteLayoutManager();
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(layout);
        final JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel.setBackground(Color.gray);
        panel.setVisible(true);
        layeredPane.add(panel);
        layout.setBounds(panel, new Rectangle(17, 59, 436, 480));
        frame.add(layeredPane);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestJLayeredPane().initUI();
            }
        });
    }
}