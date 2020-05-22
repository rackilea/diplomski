import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class NavigationFilterPrefixWithBackspace extends NavigationFilter
{
    private int prefixLength;
    private Action deletePrevious;

    public NavigationFilterPrefixWithBackspace(int prefixLength, JTextComponent component)
    {
        this.prefixLength = prefixLength;
        deletePrevious = component.getActionMap().get("delete-previous");
        component.getActionMap().put("delete-previous", new BackspaceAction());
        component.setCaretPosition(prefixLength);
    }

    public void setDot(NavigationFilter.FilterBypass fb, int dot, Position.Bias bias)
    {
        fb.setDot(Math.max(dot, prefixLength), bias);
    }

    public void moveDot(NavigationFilter.FilterBypass fb, int dot, Position.Bias bias)
    {
        fb.moveDot(Math.max(dot, prefixLength), bias);
    }

    class BackspaceAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            JTextComponent component = (JTextComponent)e.getSource();

            if (component.getCaretPosition() > prefixLength)
            {
                deletePrevious.actionPerformed( null );
            }
        }
    }

    public static void main(String args[]) throws Exception {

        JTextField textField = new JTextField("Prefix_", 20);
        textField.setNavigationFilter( new NavigationFilterPrefixWithBackspace(7, textField) );

        JFrame frame = new JFrame("Navigation Filter Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(textField);
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}