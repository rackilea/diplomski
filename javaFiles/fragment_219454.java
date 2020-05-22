import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridBagSSCCE extends JPanel
{
    JPanel red;
    JPanel green;

    public GridBagSSCCE()
    {
        setLayout( new GridBagLayout() );
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;

        red = new JPanel();
        red.setBackground( Color.RED );
        red.setPreferredSize( new Dimension(300, 10) );
        gbc.weighty = 0.1;
        add(red, gbc);

        green = new JPanel();
        green.setBackground( Color.GREEN );
        green.setPreferredSize( new Dimension(300, 90) );
        gbc.gridy = 1;
        gbc.weighty = 0.9;
        add(green, gbc);

        JPanel buttons = new JPanel();
        buttons.add( new JButton("Ok") );
        buttons.add( new JButton("Cancel") );
        buttons.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
        gbc.gridy = 2;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(buttons, gbc);

        addComponentListener( new ComponentAdapter()
        {
            public void componentResized(ComponentEvent e)
            {
                System.out.println(red.getSize() + " : " + green.getSize());
            }
        });
    }

    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("GridBagSSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new GridBagSSCCE() );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}