import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SSCCE extends JPanel
{
    public SSCCE()
    {
        JPanel left = new JPanel( new FlowLayout(FlowLayout.LEFT) );
        JPanel leftBox = new JPanel();
        leftBox.setPreferredSize( new Dimension(200, 50) );
        leftBox.setBackground( Color.BLACK );
        left.add( leftBox );

        JPanel center = new JPanel( new FlowLayout(FlowLayout.CENTER) );
        center.setOpaque(false);
        JPanel centerBox = new JPanel();
        centerBox.setPreferredSize( new Dimension(50, 50) );
        centerBox.setBackground( Color.RED );
        center.add( centerBox );

        JPanel right = new JPanel( new FlowLayout(FlowLayout.RIGHT) );
        JPanel rightBox = new JPanel();
        rightBox.setPreferredSize( new Dimension(50, 50) );
        rightBox.setBackground( Color.BLACK );
        right.add( rightBox );

        JPanel main = new JPanel( new BorderLayout() );
        main.add(left, BorderLayout.LINE_START);
        main.add(right, BorderLayout.LINE_END);

        setLayout( new OverlayLayout(this) );
        add(center);
        add(main);
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SSCCE());
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