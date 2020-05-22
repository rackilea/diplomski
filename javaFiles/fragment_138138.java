import java.awt.Component;
import java.util.Vector;

import javax.swing.FocusManager;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Test {

    public static class MyTableModel extends DefaultTableModel {
        private int count;

        public MyTableModel() {
            addColumn("Test");
        }

        public void insertNewRow() {
            Vector<String> rowData = createNewRowData();
            insertRow(0, rowData);
        }

        private Vector<String> createNewRowData() {
            Vector<String> data = new Vector<String>(1);
            data.add("Hello-" + count++);
            return data;
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().initUI();
            }
        });
    }

    public void initUI() {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final MyTableModel model = new MyTableModel();
        final JTable table = new JTable(model);
        for (int i = 0; i < 100; i++) {
            model.insertNewRow();
        }
        final JLabel label = new JLabel();
        JDialog dialog = new JDialog(frame, false);
        dialog.add(label);
        dialog.setSize(300, 50);
        dialog.setLocation(400, 0);
        dialog.setVisible(true);
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                final Component focused = FocusManager.getCurrentManager().getFocusOwner();
                int index = table.getSelectionModel().getLeadSelectionIndex();
                if (index > -1) {
                    Object valueAt = model.getValueAt(index, 0);
                    label.setText("Current row selected is: " + valueAt);
                } else {
                    label.setText("No selection");
                }
                label.grabFocus();
                if (focused != null) {
                    SwingUtilities.invokeLater(new Runnable() {

                        @Override
                        public void run() {
                            frame.toFront();
                        }
                    });
                }
            }
        });
        final JScrollPane scroll = new JScrollPane(table);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.add(scroll);
        frame.pack();
        frame.setVisible(true);

    }
}