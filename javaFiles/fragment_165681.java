import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridBagLayoutExample {

    private static final int GAP = 5;
    private GridBagConstraints gbc;

    private JTextArea insertQueryTextArea;
    private JTextArea resultTextArea;
    private JScrollPane scroller;
    private JButton executeQueryButton;

    public GridBagLayoutExample () {
        gbc = new GridBagConstraints ();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets ( GAP, GAP, GAP, GAP );
        gbc.fill = GridBagConstraints.BOTH;
    }

    private void displayGUI () {
        JFrame frame = new JFrame ( "" );
        frame.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );

        JPanel contentPane = getPanel ();
        contentPane.setLayout ( new BorderLayout ( GAP, GAP) );

        JPanel containerPanel = getPanel ();
        containerPanel.setLayout ( new GridBagLayout () );
        addComponent ( 0, 0, 1, 1, 1.0, 0.1, containerPanel,
            new JLabel ( "Please inesrt your DML query here: ", JLabel.CENTER ) );
        insertQueryTextArea = getTextArea ();
        scroller = new JScrollPane ();
        scroller.setViewportView ( insertQueryTextArea );
        addComponent ( 0, 1, 1, 1, 1.0, 0.4, containerPanel, scroller );
        JPanel buttonPanel = getPanel ();
        executeQueryButton = new JButton ( "Execute Query" );
        buttonPanel.add ( executeQueryButton );
        addComponent ( 0, 2, 1, 1, 1.0, 0.1, containerPanel, buttonPanel );
        resultTextArea = getTextArea ();
        scroller = new JScrollPane ();
        scroller.setViewportView ( resultTextArea );
        addComponent ( 0, 3, 1, 1, 1.0, 0.4, containerPanel, scroller );

        contentPane.add ( containerPanel, BorderLayout.CENTER );

        frame.setContentPane ( contentPane );
        frame.pack ();
        frame.setLocationByPlatform ( true );
        frame.setVisible ( true );
    }

    private void addComponent ( int gridx, int gridy,
                                    int gridwidth, int gridheight,
                                    double weightx, double weighty,
                                    JComponent container, JComponent component ) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.weightx = weightx;
        gbc.weighty = weighty;

        container.add ( component, gbc );
    }

    private JTextArea getTextArea () {
        JTextArea tArea = new JTextArea ( 10, 10 );
        tArea.setLineWrap ( true );
        tArea.setWrapStyleWord ( true );

        return tArea;
    }

    private JPanel getPanel () {
        JPanel panel = new JPanel ();
        panel.setOpaque ( true );
        panel.setBorder ( BorderFactory.createEmptyBorder ( GAP, GAP, GAP, GAP ) );

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