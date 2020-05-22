import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class NestedLayout {

    private static final int GAP = 5;
    private Random random;

    public NestedLayout () {
        random = new Random ();
    }

    private void displayGUI () {
        JFrame frame = new JFrame ( "Nested Layout Example" );
        frame.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );

        JPanel contentPane = new JPanel ();
        contentPane.setBorder ( BorderFactory.createEmptyBorder (
                                GAP, GAP, GAP, GAP) );
        contentPane.setLayout ( new GridLayout ( 4, 1, GAP, GAP ) );

        contentPane.add ( getHeaderPanel () );
        contentPane.add ( getMiddlePanel () );
        contentPane.add ( getFooterPanel () );
        contentPane.add ( getPSPanel () );

        frame.setContentPane ( contentPane );
        frame.pack ();
        frame.setLocationByPlatform ( true );
        frame.setVisible ( true );
    }

    private JPanel getHeaderPanel () {
        JPanel panel = new JPanel ();
        panel.setLayout ( new BorderLayout ( GAP, GAP) );
        panel.setBorder ( BorderFactory.createEmptyBorder (
                                GAP, GAP, GAP, GAP) );
        panel.add ( getLabel ( "Header JLabel" ), BorderLayout.CENTER );

        return panel;
    }

    private JPanel getMiddlePanel () {
        JPanel panel = new JPanel ();
        panel.setLayout ( new GridBagLayout () );
        panel.setBorder ( BorderFactory.createEmptyBorder (
                                GAP, GAP, GAP, GAP) );
        panel.add ( getLabel ( "Middle JLabel" ) );

        return panel;
    }

    private JPanel getFooterPanel () {
        JPanel panel = new JPanel ();
        panel.setLayout ( new BorderLayout ( GAP, GAP) );
        panel.setBorder ( BorderFactory.createEmptyBorder (
                                GAP, GAP, GAP, GAP) );

        panel.add ( getLabel ( "Left JLabel" ), BorderLayout.LINE_START );
        panel.add ( getLabel ( "Center JLabel" ), BorderLayout.CENTER );
        panel.add ( getLabel ( "Right JLabel" ), BorderLayout.LINE_END );

        return panel;
    }

    private JPanel getPSPanel () {
        JPanel panel = new JPanel ();
        panel.setLayout ( new FlowLayout ( FlowLayout.RIGHT, GAP, GAP) );
        panel.setBorder ( BorderFactory.createEmptyBorder (
                                GAP, GAP, GAP, GAP) );

        panel.add ( getLabel ( "First JLabel" ) );
        panel.add ( getLabel ( "Second JLabel" ) );

        return panel;
    }

    private JLabel getLabel ( String text ) {
        JLabel label = new JLabel ( text, JLabel.CENTER );
        label.setOpaque ( true );
        label.setBackground ( getRandomColour () );
        return label;
    }

    private Color getRandomColour () {
        return new Color ( random.nextFloat (), random.nextFloat (),
                            random.nextFloat (), random.nextFloat () );
    }

    public static void main ( String[] args ) {
        Runnable runnable = new Runnable () {
            @Override
            public void run () {
                new NestedLayout ().displayGUI ();
            }
        };
        EventQueue.invokeLater ( runnable );
    }
}