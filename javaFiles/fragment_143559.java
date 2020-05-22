import java.awt.*;
import javax.accessibility.AccessibleContext;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboPopup;

public class ComboTest {
  public JComponent makeUI() {
    // TEST:
    // UIManager.put("ComboBox.selectionBackground", Color.GREEN);
    // UIManager.put("ComboBox.selectionForeground", Color.CYAN);

    String[] model = {"Male", "Female"};

    JComboBox<String> combo1 = new JComboBox<>(model);
    AccessibleContext ac = combo1.getAccessibleContext();
    BasicComboPopup pop = (BasicComboPopup) ac.getAccessibleChild(0);
    JList list = pop.getList();
    list.setSelectionForeground(Color.WHITE);
    list.setSelectionBackground(Color.ORANGE);

    // ???: The focus border of the JComboBox is not drawn.
    JComboBox<String> combo2 = new JComboBox<>(model);
    combo2.setRenderer(new DefaultListCellRenderer() {
      @Override public Component getListCellRendererComponent(
          JList list, Object value, int index,
          boolean isSelected, boolean hasFocus) {
        JLabel l = (JLabel) super.getListCellRendererComponent(
            list, value, index, isSelected, hasFocus);
        if (isSelected) {
          l.setForeground(Color.WHITE);
          l.setBackground(Color.ORANGE);
        } else {
          l.setForeground(Color.BLACK);
          l.setBackground(Color.WHITE);
        }
        return l;
      }
    });

//     // TEST:
//     JComboBox<String> combo3 = new JComboBox<>(model);
//     combo3.setRenderer(new DefaultListCellRenderer() {
//       @Override public Component getListCellRendererComponent(
//           JList list, Object value, int index,
//           boolean isSelected, boolean hasFocus) {
//         list.setSelectionForeground(Color.WHITE);
//         list.setSelectionBackground(Color.ORANGE);
//         return super.getListCellRendererComponent(
//             list, value, index, isSelected, hasFocus);
//       }
//     });

    JPanel box = new JPanel(new GridLayout(0, 1, 10, 10));
    box.add(combo1);
    box.add(combo2);
//     box.add(combo3);

    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    p.add(box, BorderLayout.NORTH);
    return p;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        // UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
      } catch (Exception e) {
        e.printStackTrace();
      }
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new ComboTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}