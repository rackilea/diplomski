package example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/** Extend default model to make cells non-editable */
class MyTableModel extends DefaultTableModel {
    public MyTableModel(Object[][] data, Object[] headers) {
        super(data, headers);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

/** Key listener that controls row highlighting */
class SearchingKeyAdapter extends KeyAdapter {
    private final JTable table;
    private int selectedRow = -1;//before start

    public SearchingKeyAdapter(JTable table) {
        this.table = table;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String keyChar = String.valueOf(e.getKeyChar());
        TableModel model = table.getModel();
        int startRow = selectedRow;
        if (selectedRow == model.getRowCount() - 1) {
            startRow = -1;//Go before start
        }
        //Check each cell to see if it starts with typed char.
        //if so set corresponding row selected and return.
        for (int row = startRow+1; row < model.getRowCount(); row++) {
            for (int col = 0; col < model.getColumnCount(); col++) {
                String value = (String) model.getValueAt(row, col);
                if (value != null && value.startsWith(keyChar)) {
                    table.getSelectionModel().clearSelection();
                    table.getColumnModel().getSelectionModel().clearSelection();
                    table.setRowSelectionInterval(row, row);
                    selectedRow = row;
                    return;
                }
            }
        }

    }
}

public class App {
    JFrame frame;
    JTable table;
    String[][] data = {
            {"for", "util", "synchronized", "final"}, {"finally", "throw", "throws", "try"}, {"import", "class", "interface", "if"}, {"public", "private", "protected", "volatile"}
    };
    String[] headers = {"Keyword1", "Keyword2", "Keyword3", "Keyword3"};

    public App() {
        table = new JTable();
        table.setModel(new MyTableModel(data, headers));
        //Add special key listener that will move highlight based on typed char
        table.addKeyListener(new SearchingKeyAdapter(table));
        //We need to have only single selection
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                App app = new App();
            }
        });
    }
}