import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class ComboBoxListeners {

    private JFrame f;
    private JComboBox comboBox;
    private JLabel label = new JLabel();
    private DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();

    public ComboBoxListeners() {
        comboBox = new JComboBox(comboBoxModel);
        comboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if ((e.getStateChange() == ItemEvent.SELECTED)) {
                    String str = comboBox.getSelectedItem().toString();
                    label.setText("Selected Value From JComboBox is :   " + str);
                }
            }
        });
        label.setPreferredSize(new Dimension(400, 30));
        JButton btnAdd = new JButton(new AbstractAction("Append Items") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                addNewItemsFromDatabase();
            }
        });
        JButton btnRefresh = new JButton(new AbstractAction("Refresh Items") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                refreshItemsFromDatabase();
            }
        });
        f = new JFrame("ComboBox ItemListeners");
        f.setLayout(new GridLayout(0, 1, 15, 15));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(comboBox);
        f.add(label);
        f.add(btnAdd);
        f.add(btnRefresh);
        f.setLocation(150, 150);
        f.pack();
        f.setVisible(true);
    }

    public void addNewItemsFromDatabase() {
        ArrayList<Integer> ageList = new ArrayList<Integer>();
        for (int i = 1; i <= 5; ++i) {
            ageList.add(i);
        }
        for (final Integer i : ageList) {
            EventQueue.invokeLater(new Runnable() {

                public void run() {// updates to the Swing GUI must be done on EDT
                    comboBoxModel.addElement(i);
                }
            });
        }
    }

    public void refreshItemsFromDatabase() {
        comboBoxModel = new DefaultComboBoxModel();
        ArrayList<Integer> ageList = new ArrayList<Integer>();
        for (int i = 1; i <= 5; ++i) {
            ageList.add(i);
        }
        for (final Integer i : ageList) {
            EventQueue.invokeLater(new Runnable() {

                public void run() {// updates to the Swing GUI must be done on EDT
                    comboBoxModel.addElement(i);
                }
            });
        }
        comboBox.setModel(comboBoxModel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ComboBoxListeners comboBoxListeners = new ComboBoxListeners();
            }
        });
    }
}