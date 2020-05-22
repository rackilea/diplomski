import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class IconSSCCE extends JPanel implements ActionListener
{
    JLabel label = new JLabel();
    TextIcon text;
    ImageIcon image;
    Float angle = 0.0f;

    public IconSSCCE()
    {
        setLayout( new BorderLayout() );

        text = new TextIcon(label, "Some Text", TextIcon.Layout.HORIZONTAL);
//      text = new TextIcon(label, "", TextIcon.Layout.HORIZONTAL);
        image = new ImageIcon("dukeWaveRed.gif");
        CompoundIcon ci = new CompoundIcon(CompoundIcon.Axis.X_AXIS, image, text);
        label.setIcon( ci );
        add(label, BorderLayout.NORTH);

        JButton rotate = new JButton("Rotate");
        add(rotate, BorderLayout.SOUTH);
        rotate.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new Timer(50, IconSSCCE.this).start();
            }
        });
    }

    public void actionPerformed(ActionEvent e)
    {
        angle++;

        RotatedIcon ri = new RotatedIcon(image, angle);
        CompoundIcon ci = new CompoundIcon(ri, text);
        label.setIcon( ci );
    }

    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("IconSSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new IconSSCCE() );
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