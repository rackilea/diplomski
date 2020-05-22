import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuItemAction implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        JMenuItem mi = (JMenuItem)e.getSource();
        mi.setText(mi.getText() + "0");
        JMenu menu = getMenuBarMenu(mi);
        System.out.println("Menu: " + menu.getText());

        JFrame frame = (JFrame)SwingUtilities.windowForComponent(menu);
        System.out.println("Frame: " + frame.getTitle());
    }

    private JMenu getMenuBarMenu(JMenuItem item)
    {
        JMenu menu = null;

        while (menu == null)
        {
            JPopupMenu popup = (JPopupMenu)item.getParent();
            item = (JMenuItem)popup.getInvoker();

            if (! (item.getParent() instanceof JPopupMenu) )
                menu = (JMenu)item;
        }

        return menu;
    }


    private static void createAndShowGUI()
    {
        ActionListener listener = new MenuItemAction();

        // Create menu bar

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu( "File" );
        menuBar.add( menu );

        JMenuItem item1 = new JMenuItem("Item 1");
        menu.add( item1 );

        JMenu subMenu1 = new JMenu("SubMenu 1");
        menu.add( subMenu1 );

        JMenuItem subItem1 = new JMenuItem("SubItem 1");
        subMenu1.add( subItem1 );

        JMenu subMenu12 = new JMenu("SubMenu 12");
        subMenu1.add( subMenu12 );

        JMenuItem subItem12 = new JMenuItem("SubItem 12");
        subMenu12.add( subItem12 );

        item1.addActionListener( listener );
        subItem1.addActionListener( listener );
        subItem12.addActionListener( listener );

        JFrame frame = new JFrame("Get Menu and Frame");
        frame.setJMenuBar( menuBar );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize(200, 200);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }
}