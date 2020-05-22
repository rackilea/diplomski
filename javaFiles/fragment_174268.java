package com.test;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class ChequeGUI extends JFrame {

JTable guiTable = new JTable();

ChequeTableModel model;

public ChequeGUI() throws SQLException {

    guiTable.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {

            // guiTable.getTableHeader().getDefaultRenderer();

            int row = guiTable.getSelectedRow();

            Cheque c = model.getChequeByRow(row);

            try {
                PrintChequeGUI pcg = new PrintChequeGUI(c);
                pcg.setTitle("Print Cheque");
                pcg.setVisible(true);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    });

    model = new ChequeTableModel();
    guiTable.setModel(model);
    add(new JScrollPane(guiTable));

    model.loadData();

}

public class ChequeTableModel extends AbstractTableModel {

    List<Cheque> dataModel;

    String[] columns = { "Cheque Number", "Payee Name", "Cheque Amount",
            "Cheque Date" };

    public ChequeTableModel() {
        super();
        dataModel = new ArrayList<Cheque>();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getRowCount() {
        return dataModel.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object value = null;

        Cheque c = getChequeByRow(row);
        switch (column) {
        case 0:
            value = c.chqNo;
            break;
        case 1:
            value = c.payName;
            break;
        case 2:
            value = c.chkAmount;
            break;
        case 3:
            value = c.chkDate;
            break;

        default:
            break;
        }
        return value;
    }

    public Cheque getChequeByRow(int row) {
        if (dataModel.size() <= 0)
            return null;
        if (row < 0)
            return null;

        return dataModel.get(row);
    }

    public void loadData() {
        /*
         * 
         * //Uncomment this for database connection and load data from
         * database; //Please note to disconnect database if not needed
         * 
         * 
         * DBConnection connection = new DBConnection();
         * 
         * // Populate Table ChequeDAOImpl chqdi = new ChequeDAOImpl();
         * chqdi.setConnection(connection); List<Cheque> cheques =
         * chqdi.getCheques();
         * 
         * for (Cheque cq : cheques) { model.addRow(new Object[] {
         * cq.getChqNum(), cq.getName(), cq.getAmount(), cq.getDate() }); }
         */

        for (int i = 0; i < 10; i++) {
            Cheque c = new Cheque();
            c.chkAmount = i * 1000;
            c.chqNo = String.valueOf(i);
            c.chkDate = new Date(System.currentTimeMillis());
            dataModel.add(c);
        }
        fireTableRowsInserted(0, dataModel.size());
    }

}

public static void main(String[] args) throws SQLException {
    ChequeGUI c = new ChequeGUI();
    c.pack();
    c.setVisible(true);
}