import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;

/** @see https://stackoverflow.com/a/41519646/230513 */
public class DynamicJList {

    private final JList<String> list1 = new JList<>(new String[]{"A", "B"});
    private final JList<String> list2 = new JList<>();
    private final List<DefaultListModel> models = new ArrayList<>();

    private void display() {
        JFrame f = new JFrame("DynamicJList");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultListModel<String> model1 = new DefaultListModel<>();
        model1.addElement("A1");
        model1.addElement("A2");
        model1.addElement("A3");
        models.add(model1);
        DefaultListModel<String> model2 = new DefaultListModel<>();
        model2.addElement("B1");
        model2.addElement("B2");
        models.add(model2);
        list2.setModel(model1);
        list1.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                list2.setModel(models.get(list1.getSelectedIndex()));
            }
        });
        JPanel panel = new JPanel(new GridLayout(1, 0));
        panel.add(list1);
        panel.add(list2);
        f.add(panel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new DynamicJList()::display);
    }
}