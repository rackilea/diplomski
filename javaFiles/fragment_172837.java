import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class Main2 extends JPanel {
    private JList<String> list1 = new JList<>(new String[] { "one", "two", "three" });
    private JList<String> list2 = new JList<>(new String[] { "hello", "goodbye", "yes" });
    private JTextField selectedItemTxtFld = new JTextField(10);

    public Main2() {
        list1.setName("list 1");
        list2.setName("list 2");
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list1.addListSelectionListener(new MySelectionListener(list2));
        list2.addListSelectionListener(new MySelectionListener(list1));

        JPanel listPanel = new JPanel(new GridLayout(1, 0));
        listPanel.add(new JScrollPane(list1));
        listPanel.add(new JScrollPane(list2));

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Selection:"));
        topPanel.add(selectedItemTxtFld);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
        add(listPanel, BorderLayout.CENTER);
    }

    private class MySelectionListener implements ListSelectionListener {
        private JList<String> otherList;

        public MySelectionListener(JList<String> otherList) {
            this.otherList = otherList;
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            // otherList.clearSelection();
            if (e.getValueIsAdjusting()) {
                otherList.clearSelection();
            } else {
                JList<String> thisList = (JList<String>) e.getSource();
                if (!thisList.isSelectionEmpty()) {
                    String selectedText = thisList.getSelectedValue().toString();
                    selectedItemTxtFld.setText(selectedText);
                }
            }
        }
    }

    private static void createAndShowGui() {
        Main2 mainPanel = new Main2();

        JFrame frame = new JFrame("Main2");
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