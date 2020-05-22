import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScrollSSCCE extends JPanel
{
    public ScrollSSCCE()
    {
        setLayout( new BorderLayout() );

        final JPanel panel = new JPanel();
        panel.setPreferredSize( new Dimension(200, 200) );
        JScrollPane scrollPane = new JScrollPane( panel );
        add( scrollPane );

        JButton button = new JButton("Adjust");
        add(button, BorderLayout.SOUTH);
        button.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Dimension d = panel.getPreferredSize();
                d.width +=50;
                d.height +=50;
                panel.setPreferredSize(d);
                panel.revalidate();
            }
        });
    }

    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("ScrollSSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new ScrollSSCCE() );
        frame.setSize(150, 150);
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