package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Menu;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class Table extends JFrame

{
    // Instance attributes used in this example

    private JPanel topPanel;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton update_Button;

    // Constructor of main frame
    public Table() {
        // Set the frame characteristics
        setTitle("Add new item");
        setSize(300, 200);
        setBackground(Color.gray);

        // Create a panel to hold all other components
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        // Create columns names
        String columnNames[] = { "Item Description", "Item Type", "Item Price" };

        // Create some data
        Object dataValues[][];
        Item itm = new Item();
        dataValues = itm.data;

        // Create a new table instance
        table = new JTable(dataValues, columnNames);

        // //////////////////////////

        JComboBox itemTypeCombobox = new JComboBox();
        TableColumn column1 = table.getColumnModel().getColumn(1);
        column1.setCellEditor(new DefaultCellEditor(itemTypeCombobox));

        // //////////////////////////

        // Add the table to a scrolling pane
        scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);
        JButton button = new JButton("Add Item");
        topPanel.add(button, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        Menu m = new Menu();
        // Create an instance of the test application
        Table mainFrame = new Table();
        mainFrame.setVisible(true);
    }

}