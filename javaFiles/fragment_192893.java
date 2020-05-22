import java.awt.*;
import javax.swing.*;

public class GridBagLayoutExample {

    private GridBagConstraints m_GBC;

    public GridBagLayoutExample () {
        m_GBC = new GridBagConstraints ();
        m_GBC.anchor = GridBagConstraints.FIRST_LINE_START;
        m_GBC.fill = GridBagConstraints.BOTH;
    }

    private void displayGUI () {
        JFrame frame = new JFrame ( "GridBagLayout Example" );
        frame.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );

        JPanel contentPane = new JPanel ();
        contentPane.setLayout ( new GridBagLayout () );

        addComponent ( contentPane, getPanel (), 0, 0, 1, 1, 1.0, 0.1 );
        addComponent ( contentPane, getPanel (), 0, 1, 1, 5, 1.0, 0.5 );
        addComponent ( contentPane, getPanel (), 0, 6, 1, 1, 1.0, 0.1 );
        addComponent ( contentPane, getPanel (), 0, 7, 1, 2, 1.0, 0.2 );
        addComponent ( contentPane, getPanel (), 0, 9, 1, 1, 1.0, 0.1 );

        frame.setContentPane ( contentPane );
        frame.pack ();
        frame.setLocationByPlatform ( true );
        frame.setVisible ( true );
    }

    private void addComponent ( JComponent contentPane, JComponent component,
                                int x, int y, int gridwidth, int gridheight,
                                double weightx, double weighty ) {
        m_GBC.gridx = x;
        m_GBC.gridy = y;
        m_GBC.gridwidth = gridwidth;
        m_GBC.gridheight = gridheight;
        m_GBC.weightx = weightx;
        m_GBC.weighty = weighty;

        contentPane.add ( component, m_GBC );
    }

    private JPanel getPanel () {
        JPanel panel = new JPanel ();
        panel.setOpaque ( true );
        Color color = new Color ( ( float ) Math.random (), ( float ) Math.random (),
                                ( float ) Math.random (), ( float ) Math.random () );
        panel.setBackground ( color );

        return panel;
    }

    public static void main ( String [] args ) {
        Runnable runnable = new Runnable () {
            @Override
            public void run () {
                new GridBagLayoutExample ().displayGUI ();
            }
        };
        EventQueue.invokeLater ( runnable );
    }
}