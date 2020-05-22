import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class TabbedPaneBinding extends JFrame
{
    public TabbedPaneBinding()
    {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu( "File" );
        menuBar.add( menu );
        JMenuItem menuItem = new JMenuItem("Search");
        menuItem.setAccelerator( KeyStroke.getKeyStroke("control F") );
        menu.add( menuItem );

        menuItem.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("do Search");
            }
        });

        add(new JTextField(10), BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Text Field", new JTextField(10));
        tabbedPane.addTab("CheckBox", new JCheckBox());
        add(tabbedPane);

        AbstractAction action = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("tabbed pane Search");
            }
        };

        String keyStrokeAndKey = "control F";
        KeyStroke keyStroke = KeyStroke.getKeyStroke(keyStrokeAndKey);
//      InputMap im = tabbedPane.getInputMap(JTabbedPane.WHEN_FOCUSED);
        InputMap im = tabbedPane.getInputMap(JTabbedPane.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        im.put(keyStroke, keyStrokeAndKey);
        tabbedPane.getActionMap().put(keyStrokeAndKey, action);
    }

    public static void main(String args[])
    {
        TabbedPaneBinding frame = new TabbedPaneBinding();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.setSize(200, 150);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}