import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableCellListenerTest2
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI()
    {
        final JTable table = new JTable( TableCellListenerTest2.createModel());
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);

        Action action = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                TableCellListener tcl = (TableCellListener)e.getSource();
                System.out.println( tcl.getOldValue() + " : " + tcl.getNewValue() );
            }
        };

        TableCellListener tcl = new TableCellListener(table, action);

        JButton button = new JButton("Reset Model");
        button.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                table.setModel( TableCellListenerTest2.createModel() );
            }
        });

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Table Cell Listener");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( scrollPane );
        frame.add(button, BorderLayout.SOUTH);
        frame.setSize(400, 160);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }

    public static TableModel createModel()
    {
        Random random = new Random();

        DefaultTableModel model = new DefaultTableModel(10, 2);

        for (int i = 0; i < model.getRowCount(); i++)
            model.setValueAt("" + random.nextInt(100), i, 0);

        return model;
    }
}