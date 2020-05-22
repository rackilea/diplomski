import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class JListTest {

    public JListTest() {
        JFrame frame = new JFrame();
        frame.setTitle("JList Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents(frame);

        frame.pack();
        frame.setVisible(true);
    }

    private void initComponents(JFrame frame) {
        String[] strs = {"swing", "home", "basic", "metal"};

        final JList checkBoxesJList = new JList(createData(strs));
        checkBoxesJList.setCellRenderer(new CheckListRenderer());
        checkBoxesJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        checkBoxesJList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int index = checkBoxesJList.locationToIndex(e.getPoint());
                CheckableItem item = (CheckableItem) checkBoxesJList.getModel().getElementAt(index);
                item.setSelected(!item.isSelected());
                Rectangle rect = checkBoxesJList.getCellBounds(index, index);
                checkBoxesJList.repaint(rect);
            }
        });

        JScrollPane scrollPane = new JScrollPane(checkBoxesJList);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    private CheckableItem[] createData(String[] strs) {
        int n = strs.length;
        CheckableItem[] items = new CheckableItem[n];
        for (int i = 0; i < n; i++) {
            items[i] = new CheckableItem(strs[i]);
        }
        return items;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JListTest();
            }
        });
    }
}

class CheckListRenderer extends JCheckBox implements ListCellRenderer {

    public CheckListRenderer() {
        setBackground(UIManager.getColor("List.textBackground"));
        setForeground(UIManager.getColor("List.textForeground"));
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean hasFocus) {
        setEnabled(list.isEnabled());
        setSelected(((CheckableItem) value).isSelected());
        setFont(list.getFont());
        setText(value.toString());
        return this;
    }
}

class CheckableItem {

    private String str;
    private boolean isSelected;

    public CheckableItem(String str) {
        this.str = str;
        isSelected = false;
    }

    public void setSelected(boolean b) {
        isSelected = b;
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public String toString() {
        return str;
    }
}