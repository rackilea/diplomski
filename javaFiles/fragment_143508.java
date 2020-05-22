import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ComboBoxRenderer extends JLabel implements ListCellRenderer
{
    private boolean colorSet;
    private Color selectionBackgroundColor;

    public ComboBoxRenderer()
    {
        setOpaque(true);
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(CENTER);
        colorSet = false;
        selectionBackgroundColor = Color.red; // Have to set a color, else a compiler error will occur
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        // Check if color is set (only runs the first time)
        if(!colorSet)
        {
            // Set the list' background color to original selection background of the list
            selectionBackgroundColor = list.getSelectionBackground();
            // Do this only one time since the color will change later
            colorSet = true;
        }

        // Set the list' background color to white (white will show once selection is made)
        list.setSelectionBackground(Color.white);

        // Check which item is selected
        if(isSelected)
        {
            // Set background color of the item your cursor is hovering over to the original background color
            setBackground(selectionBackgroundColor);
        }
        else
        {
            // Set background color of all other items to white
            setBackground(Color.white);
        }

        // Do nothing about the text and font to be displayed
        setText((String)value);
        setFont(list.getFont());

        return this;
    }
}