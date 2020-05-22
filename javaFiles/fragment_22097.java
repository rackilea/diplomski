import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;

public class DialogEscape extends JDialog
{
    private JPopupMenu popup;

    public DialogEscape()
    {
        popup = new JPopupMenu();
        popup.add( new JMenuItem("SubMenuA") );
        popup.add( new JMenuItem("SubMenuB") );
        popup.add( new JMenuItem("SubMenuC") );
        popup.add( new JMenuItem("SubMenuD") );

        String[] items = { "Select Item", "Color", "Shape", "Fruit" };
        JComboBox comboBox = new JComboBox( items );
        add(comboBox, BorderLayout.NORTH);

        JTextField textField = new JTextField("Right Click For Popup");
        textField.setComponentPopupMenu(popup);
        add(textField);

        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                boolean openPopup = false;
                Component c = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();

                //  Check if light weight popup is being used

                List<JPopupMenu> popups = SwingUtils.getDescendantsOfType(JPopupMenu.class, (Container)c, true);

                for (JPopupMenu p: popups)
                {
                    p.setVisible( false );
                    openPopup = true;
                }

                //  Check if a heavy weight popup is being used

                Window window = SwingUtilities.windowForComponent(c);
                Window[] windows = window.getOwnedWindows();

                for (Window w: windows)
                {
                    if (w.isVisible()
                    &&  w.getClass().getName().endsWith("HeavyWeightWindow"))
                    {
                        openPopup = true;
                        w.dispose();
                    }
                }

                //  No popups so close the Window

                if (! openPopup)
//                  SwingUtilities.windowForComponent(c).setVisible(false);
                    SwingUtilities.windowForComponent(c).dispose();
            }
        };

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }

    public static void main(String[] args)
    {
        String laf = null;
        laf = "javax.swing.plaf.metal.MetalLookAndFeel";
//      laf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
//      laf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";

        try { UIManager.setLookAndFeel(laf); }
        catch (Exception e2) { System.out.println(e2); }

        JDialog dialog = new DialogEscape();
        dialog.setDefaultCloseOperation( HIDE_ON_CLOSE );
        dialog.setSize(200, 200);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible( true );
    }
}