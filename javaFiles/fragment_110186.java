import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableRenderer extends JPanel
{
    public TableRenderer()
    {
        String[] columnNames = {"String", "Integer"};
        Object[][] data =
        {
            {"A", new Integer(1)},
            {"B", new Integer(2)},
            {"C", new Integer(10)},
            {"D", new Integer(4)}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable( model );
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane( table );
        add( scrollPane );

        //  Override default renderer on a specific column

        TableCellRenderer colorRenderer = new ColorRenderer();
        table.getColumnModel().getColumn(1).setCellRenderer( colorRenderer );
    }

    /*
    **  Color the focused cell
    */
    class ColorRenderer extends DefaultTableCellRenderer
    {
        public ColorRenderer()
        {
            super();
            setHorizontalAlignment(JLabel.RIGHT);
        }

        @Override
        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (isSelected)
                setBackground( table.getSelectionBackground() );
            else
            {
                setBackground( null );

                try
                {
                    int number = Integer.parseInt( value.toString() );

                    if (number > 9)
                        setBackground( Color.RED );
                }
                catch(Exception e) {}
            }

            return this;
        }
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("Color Renderer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TableRenderer());
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }
}