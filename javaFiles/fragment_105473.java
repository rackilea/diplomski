import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

public class ComboBoxItemIcon extends JFrame
{
    public ComboBoxItemIcon()
    {
        Vector model = new Vector();
        model.addElement( new Item(new ImageIcon("copy16.gif"), "copy" ) );
        model.addElement( new Item(new ImageIcon("add16.gif"), "add" ) );
        model.addElement( new Item(new ImageIcon("about16.gif"), "about" ) );

        JComboBox comboBox;

        comboBox = new JComboBox( model );
        comboBox.setRenderer( new ItemRenderer() );
        getContentPane().add(comboBox, BorderLayout.SOUTH );
    }

    class ItemRenderer extends BasicComboBoxRenderer
    {
        public Component getListCellRendererComponent(
            JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus)
        {
            super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

            Item item = (Item)value;

            if (index == -1)
            {
                setText( item.getText() );
                setIcon( null );
            }
            else
            {
                setText( item.getText() );
                setIcon( item.getIcon() );
            }

            return this;
        }
    }

    class Item
    {
        private Icon icon;
        private String text;

        public Item(Icon icon, String text)
        {
            this.icon = icon;
            this.text = text;
        }

        public Icon getIcon()
        {
            return icon;
        }

        public String getText()
        {
            return text;
        }
    }

    public static void main(String[] args)
    {
        JFrame frame = new ComboBoxItemIcon();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible( true );
     }

}