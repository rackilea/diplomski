import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class Bb extends JFrame {
private JTable table;
private DefaultTableModel model;
Vector columnNames = new Vector();
Vector data = new Vector();

@SuppressWarnings("unchecked")
public Bb() {

    String aLine;

    try {
        FileInputStream fin = new FileInputStream("test1.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fin));

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        while (st1.hasMoreTokens()) {
            columnNames.addElement(st1.nextToken());
        }

        while ((aLine = br.readLine()) != null) {
            StringTokenizer st2 = new StringTokenizer(aLine, " ");
            Vector row = new Vector();
            while (st2.hasMoreTokens()) {
                row.addElement(st2.nextToken());
            }
            data.addElement(row);
        }
        br.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    table = new JTable(new DefaultTableModel(getDefaultData(), columnNames) {
        private static final long serialVersionUID = 1L;

        @Override
        public Class getColumnClass(int column) {
            return Integer.class;
        }
    });

    JScrollPane scrollPane = new JScrollPane(table);
    getContentPane().add(scrollPane);

    JPanel buttonPanel = new JPanel();
    getContentPane().add(buttonPanel, BorderLayout.SOUTH);

    JButton button1 = new JButton("Save");
    buttonPanel.add(button1);
    button1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (table.isEditing()) {
                int row = table.getEditingRow();
                int col = table.getEditingColumn();
                table.getCellEditor(row, col).stopCellEditing();
            }

            int rows = table.getRowCount();
            int columns = table.getColumnCount();

            try {
                StringBuilder con = new StringBuilder();
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        Object Value = table.getValueAt(i, j);
                        con.append(" ");
                        con.append(Value);
                    }
                    con.append("\r\n");
                }

                FileWriter fileWriter = new FileWriter(new File("new.txt"));

                fileWriter.write(con.toString());
                fileWriter.flush();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    });

    JButton button3 = new JButton("Refresh");
    buttonPanel.add(button3);
    button3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            refresh();
        }
    });
}

public static void main(String[] args) {
    Bb Re = new Bb();
    Re.setDefaultCloseOperation(EXIT_ON_CLOSE);
    Re.pack();
    Re.setVisible(true);
}

private void refresh() {

    DefaultTableModel dtm = new DefaultTableModel(getDefaultData(),
            columnNames) {
        private static final long serialVersionUID = 1L;

        @Override
        public Class getColumnClass(int column) {
            return Integer.class;
        }
    };
    table.setModel(dtm);
    table.revalidate();
}

private Vector getDefaultData() {
    Vector defData = new Vector();
    for (int i = 0; i < data.size(); i++) {
        Vector tmp = (Vector) data.get(i);
        Vector nVc = new Vector();
        for (int j = 0; j < tmp.size(); j++) {
            nVc.addElement(tmp.get(j));
        }
        defData.add(nVc);
    }
    return defData;
}

}