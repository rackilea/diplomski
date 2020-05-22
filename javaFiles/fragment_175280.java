import java.awt.BorderLayout;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TestTable {

    protected void initUI() {
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        Vector<String> colNames = new Vector<String>();
        for (int i = 0; i < 5; i++) {
            colNames.add("Col-" + (i + 1));
        }
        for (int i = 0; i < 200; i++) {
            Vector<Object> row = new Vector<Object>();
            for (int j = 0; j < 5; j++) {
                row.add("Cell " + (i + 1) + "-" + (j + 1));
            }
            data.add(row);
        }
        table = new JTable(data, colNames);
        someText = new JLabel();
        someText.setOpaque(true);
        table.add(someText);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                int count = table.getSelectedRowCount();
                someText.setText("You currently have selected " + count + " item" + (count > 1 ? "s" : ""));
                layoutLabel();
            }
        });
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scrollpane = new JScrollPane(table);
        scrollpane.getViewport().addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                layoutLabel();
            }
        });
        frame.add(scrollpane, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private JLabel someText;
    private JTable table;
    private JScrollPane scrollpane;

    private void layoutLabel() {
        someText.setSize(someText.getPreferredSize());
        Point location = scrollpane.getViewport().getViewRect().getLocation();
        int leadSelectionIndex = table.getSelectionModel().getLeadSelectionIndex();
        if (leadSelectionIndex > -1) {
            if (table.rowAtPoint(location) == leadSelectionIndex) {
                location.y += table.getRowHeight(leadSelectionIndex);
            }
        }
        someText.setLocation(location);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTable().initUI();
            }
        });
    }

}