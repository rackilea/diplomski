import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

public class ItemDeletion extends JPanel
{
    private JList<String> list;
    private JTable table;

    public ItemDeletion()
    {
        setLayout( new BorderLayout(5, 5) );

        String[] items =
        {
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten"
        };

        //  Add the list

        DefaultListModel<String> listModel = new DefaultListModel<String>();

        for (String item: items)
            listModel.addElement( item );

        list = new JList<String>( listModel );


        JButton listDelete = new JButton( "Delete From List" );
        listDelete.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DefaultListModel model = (DefaultListModel)list.getModel();
                int row = list.getSelectedIndex();

                while (row != -1)
                {
                    model.removeElementAt( row );
                    row = list.getSelectedIndex();
                }
            }
        });

        JPanel listPanel = new JPanel( new BorderLayout(5, 5) );
        listPanel.add(new JScrollPane( list ), BorderLayout.CENTER);
        listPanel.add(listDelete, BorderLayout.PAGE_END);

        //  Add the table

        DefaultTableModel tableModel = new DefaultTableModel(0, 1);
        List<String> tableItems = Arrays.asList( items );
        Collections.shuffle( tableItems );

        for (String item: tableItems)
        {
            System.out.println( item );
            tableModel.addRow( new String[]{item} );
        }

        table = new JTable( tableModel );

        table.setAutoCreateRowSorter(true);
        ((DefaultRowSorter)table.getRowSorter()).toggleSortOrder(0);

        JButton tableDelete = new JButton( "Delete From Table" );
        tableDelete.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                int row = table.getSelectedRow();

                while (row != -1)
                {
                    int modelRow = table.convertRowIndexToModel( row );
                    model.removeRow( modelRow );
                    row = table.getSelectedRow();
                }
            }
        });

        JPanel tablePanel = new JPanel( new BorderLayout(5, 5) );
        tablePanel.add(new JScrollPane( table ), BorderLayout.CENTER);
        tablePanel.add(tableDelete, BorderLayout.PAGE_END);

        add(listPanel, BorderLayout.LINE_START);
        add(tablePanel, BorderLayout.LINE_END);
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("Multiple Item Deletion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ItemDeletion(), BorderLayout.NORTH);
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}