import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.*;

public class ComboBoxSelect extends JFrame
{
    public ComboBoxSelect()
    {
        String[] items = { "Item1", "Item2", "Item3", "Item4", "Item5" };
        JComboBox comboBox = new JComboBox( items );
        add( comboBox );

        comboBox.addPopupMenuListener(new PopupMenuListener()
        {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e)
            {
                JComboBox comboBox = (JComboBox)e.getSource();
                BasicComboPopup popup = (BasicComboPopup)comboBox.getAccessibleContext().getAccessibleChild(0);
                JList list = popup.getList();
                list.setSelectedIndex(2);
            }

            public void popupMenuCanceled(PopupMenuEvent e) {}
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}

        });
    }

    public static void main(String[] args)
    {
        ComboBoxSelect frame = new ComboBoxSelect();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }