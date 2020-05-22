import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;

public class TabbedPaneTest {
  private int prev = 0;
  public JComponent makeUI() {
    JPanel p = new JPanel(new GridLayout(0, 1, 0, 5));
    p.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

    JTabbedPane tabbedPane0 = new SmallTabbedPane();
    JTabbedPane tabbedPane1 = new SmallTabbedPane();
    JTabbedPane tabbedPane2 = new SmallTabbedPane() {
      @Override public void addTab(String title, Component content) {
        super.addTab(title, content);
        int currentIndex = getTabCount() - 1;
        setTabComponentAt(currentIndex, new JLabel(title));
        setComponentAt(currentIndex, content);
      }
    };

    initTabbedPane(tabbedPane0);
    p.add(new JLayer<JComponent>(tabbedPane0, new DisableInputLayerUI()));

    for (JTabbedPane tabs : Arrays.asList(tabbedPane1, tabbedPane2)) {
      initTabbedPane(tabs);
      tabs.setEnabledAt(0, false);
      tabs.setEnabledAt(1, false);
      tabs.setEnabledAt(2, false);
      tabs.setEnabledAt(3, false);
      p.add(tabs);
    }

    Dictionary<Integer, Component> labelTable = new Hashtable<>();
    int c = 0;
    for (String s : Arrays.asList("tab1", "tab2", "tab2", "tab4")) {
      JLabel l = new JLabel(s);
      if (c == 0) {
        resetForeground(l, Color.RED, Color.WHITE);
      }
      labelTable.put(c++, l);
    }
    JSlider slider = new JSlider(0, 3, 0);
    //slider.setEnabled(false);
    slider.setSnapToTicks(true);
    slider.setPaintTicks(true);
    slider.setLabelTable(labelTable);
    slider.setPaintLabels(true);
    slider.getModel().addChangeListener(e -> {
      BoundedRangeModel m = (BoundedRangeModel) e.getSource();
      int i = m.getValue();
      if (i != prev) {
        Dictionary dictionary = slider.getLabelTable();
        resetForeground(dictionary.get(i), Color.RED, Color.WHITE);
        resetForeground(dictionary.get(prev), Color.BLACK, null);
        slider.repaint();
        prev = i;
      }
    });
    p.add(new JLayer<JComponent>(slider, new DisableInputLayerUI()));

    JButton button = new JButton("next");
    button.addActionListener(e -> {
      int i = tabbedPane1.getSelectedIndex() + 1;
      int next = i >= tabbedPane1.getTabCount() ? 0 : i;
      tabbedPane0.setSelectedIndex(next);
      tabbedPane1.setSelectedIndex(next);
      tabbedPane2.setSelectedIndex(next);
      slider.setValue(next);
    });

    JPanel pp = new JPanel(new BorderLayout());
    pp.add(p, BorderLayout.NORTH);
    pp.add(button, BorderLayout.SOUTH);
    return pp;
  }
  private static void initTabbedPane(JTabbedPane tabs) {
    tabs.addTab("tab1", new JLabel());
    tabs.addTab("tab2", new JLabel());
    tabs.addTab("tab3", new JLabel());
    tabs.addTab("tab4", new JLabel());
  }
  private static void resetForeground(Object o, Color fc, Color bc) {
    if (o instanceof JComponent) {
      JComponent c = (JComponent) o;
      c.setForeground(fc);
        if (bc != null) {
            c.setOpaque(true);
            c.setBackground(bc);
        } else {
            c.setOpaque(false);
        }
    }
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new TabbedPaneTest().makeUI());
      f.setSize(320, 320);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

class SmallTabbedPane extends JTabbedPane {
  @Override public Dimension getPreferredSize() {
    Dimension d = super.getPreferredSize();
    d.height = 24;
    return d;
  }
}

class DisableInputLayerUI extends LayerUI<JComponent> {
  @Override public void installUI(JComponent c) {
    super.installUI(c);
    ((JLayer) c).setLayerEventMask(
      AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK
      | AWTEvent.MOUSE_WHEEL_EVENT_MASK | AWTEvent.KEY_EVENT_MASK
      | AWTEvent.FOCUS_EVENT_MASK | AWTEvent.COMPONENT_EVENT_MASK);
  }
  @Override public void uninstallUI(JComponent c) {
    ((JLayer) c).setLayerEventMask(0);
    super.uninstallUI(c);
  }
  @Override public void eventDispatched(AWTEvent e, JLayer<? extends JComponent> l) {
    if (e instanceof InputEvent) {
      ((InputEvent) e).consume();
    }
  }
}