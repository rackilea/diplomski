package com.zetcode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class MainWindow extends JFrame {

    private JPanel EmployeePanel;
    private JButton add, remove, edit;
    private JTable EmployeeTable;
    private JScrollPane EmployeeTableScrollPane;

    private JMenuBar menu;
    private JMenu file;
    private JMenuItem exit;

    private final String[] columns = {"First Name", "Last Name", "Initials"};
    private String[][] data = {
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"},
            {"First Name", "Last Name", "Initials"}
            };



    public MainWindow(){
        //Set title
        super("Scheduler");

        initUI();

    }

    private void initUI() {

        createMenuBar();

        //Set JFrame properties
        //setSize(new Dimension(800,600));
        //setMinimumSize(new Dimension(300,300));

        //setLayout(new BorderLayout());

        //Initialize JComponents
        EmployeeTable = new JTable(data, columns){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        EmployeeTableScrollPane = new JScrollPane(EmployeeTable);

        add = new JButton("Add");
        remove = new JButton("Remove");
        edit = new JButton("Edit");


        GridBagConstraints constraints = new GridBagConstraints();
        EmployeePanel = new JPanel(new GridBagLayout());
        //Add JScrollPane
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.BOTH;
        EmployeePanel.add(EmployeeTableScrollPane, constraints);

        //Add Buttons
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.SOUTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        EmployeePanel.add(add, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.SOUTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        EmployeePanel.add(edit, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.SOUTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        EmployeePanel.add(remove, constraints);

        //Add EmployeePanel
        this.add(EmployeePanel, BorderLayout.CENTER);

        EmployeeTableScrollPane.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        EmployeeTable.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        //this.validate();
        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createMenuBar() {

        menu = new JMenuBar();
        file = new JMenu("File");
        exit = new JMenuItem("Exit");

        //Set MenuBar
        file.add(exit);
        menu.add(file);
        setJMenuBar(menu);        
    }

    public static void main(String[] args){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow ex = new MainWindow();
                ex.setVisible(true);
            }
        });
    }
}