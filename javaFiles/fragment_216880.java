import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class GridBagLayoutSparse extends JPanel
{
    public GridBagLayoutSparse()
    {
        setBorder( new LineBorder(Color.RED) );

        GridBagLayout gbl = new GridBagLayout();
        setLayout( gbl );
/*
    //  Set up a grid with 5 rows and columns.
        //  The minimimum width of a column is 50 pixels
        //  and the minimum height of a row is 20 pixels.

        int[] columns = new int[5];
        Arrays.fill(columns, 50);
        gbl.columnWidths = columns;

        int[] rows = new int[5];
        Arrays.fill(rows, 20);
        gbl.rowHeights = rows;
*/
        //  Add components to the grid at top/left and bottom/right

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        addLabel("Cell 0:0", gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        addLabel("Cell 3:4", gbc);
    }

    private void addLabel(String text, GridBagConstraints gbc)
    {
        JLabel label = new JLabel(text);
        label.setBorder( new LineBorder(Color.BLUE) );

        add(label, gbc);
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("GridBagLayoutSparse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout( new GridBagLayout() );
        frame.add(new GridBagLayoutSparse());
        frame.setSize(300, 300);
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args) throws Exception
    {
        java.awt.EventQueue.invokeLater( () -> createAndShowGUI() );
    }
}