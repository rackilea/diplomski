import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import javax.swing.*;
import javax.swing.plaf.LayerUI;

public class ScrollPaneMouseOverTest {
  public JComponent makeUI() {
    String text = String.join("\n", Collections.nCopies(100, "aaaaa"));
    JTextArea ta = new JTextArea(
        "Mouse cursor flickers over the JScrollBar.\n" + text);
    ta.addMouseListener(new MouseAdapter() {
      @Override public void mouseEntered(MouseEvent e) {
        JScrollPane sp = (JScrollPane) SwingUtilities.getAncestorOfClass(
            JScrollPane.class, (Component) e.getSource());
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      }
      @Override public void mouseExited(MouseEvent e) {
        JScrollPane sp = (JScrollPane) SwingUtilities.getAncestorOfClass(
            JScrollPane.class, (Component) e.getSource());
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
      }
    });

    JScrollPane scroll = new JScrollPane(new JTextArea(text));
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

    JPanel p = new JPanel(new GridLayout(2, 1));
    p.add(new JScrollPane(ta));
    p.add(new JLayer<>(scroll, new LayerUI<JScrollPane>() {
      @Override public void installUI(JComponent c) {
        super.installUI(c);
        if (c instanceof JLayer) {
          ((JLayer) c).setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK);
        }
      }
      @Override public void uninstallUI(JComponent c) {
        if (c instanceof JLayer) {
          ((JLayer) c).setLayerEventMask(0);
        }
        super.uninstallUI(c);
      }
      @Override protected void processMouseEvent(
            MouseEvent e, JLayer<? extends JScrollPane> l) {
        JScrollPane sp = l.getView();
        switch (e.getID()) {
          case MouseEvent.MOUSE_ENTERED:
            sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            break;
          case MouseEvent.MOUSE_EXITED:
            sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            break;
          default:
            break;
        }
        //super.processMouseEvent(e, l);
      }
    }));
    return p;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new ScrollPaneMouseOverTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}