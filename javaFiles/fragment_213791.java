import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.table.*;

public class SSCCE extends JPanel
{
    JList<String> left;
    JList<String> right;
    JLabel total;


    public SSCCE()
    {
        setLayout( new BorderLayout() );

        // change this to store Integer objects
        String[] data = { "one", "two", "three", "four", "five", "four", "six", "seven" };
        left = new JList<String>(data);
        add(new JScrollPane(left), BorderLayout.WEST);

        right = new JList<String>( new DefaultListModel<String>() );
        add(new JScrollPane(right), BorderLayout.EAST);

        JButton button = new JButton( "Copy" );
        add(button, BorderLayout.CENTER);

        button.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DefaultListModel<String> model = (DefaultListModel<String>)right.getModel();
                List<String> selected = left.getSelectedValuesList();

                for (String item: selected)
                    model.addElement( item );

                // add code here to loop through right list and total the Integer items

                total.setText("Selected total is ?");
            }
        });

        total = new JLabel("Selected total is 0");
        add(total, BorderLayout.SOUTH);
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new SSCCE() );
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