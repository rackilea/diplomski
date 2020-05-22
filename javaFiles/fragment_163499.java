import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToggleListSelectionModel extends DefaultListSelectionModel
{
    @Override
    public void setSelectionInterval(int index0, int index1)
    {
        //  Select multiple lines

        if (index0 != index1)
        {
            super.addSelectionInterval(index0, index1);
            return;
        }

        //  Toggle selection of a single line

        if  (super.isSelectedIndex(index0))
        {
            super.removeSelectionInterval(index0, index0);
        }
        else
        {
            super.addSelectionInterval(index0, index0);
        }
    }

    private static void createAndShowGUI()
    {
        String[] numbers = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };
        final JList<String> list = new JList<String>( numbers );
        list.setVisibleRowCount( numbers.length );
        list.setSelectionModel(new ToggleListSelectionModel());
//      list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JButton clear = new JButton("Clear");
        clear.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                list.clearSelection();
            }
        });

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(list), BorderLayout.CENTER);
        frame.add(clear, BorderLayout.PAGE_END);
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