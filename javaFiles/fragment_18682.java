import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class UpperCaseFilter extends DocumentFilter
{
    public void insertString(FilterBypass fb, int offs, String str, AttributeSet a)
        throws BadLocationException
    {
        replace(fb, offs, 0, str, a);
    }

    public void replace(FilterBypass fb, final int offs, final int length, final String str, final AttributeSet a)
        throws BadLocationException
    {
        if (str != null)
        {
            String converted = convertString(str);
            super.replace(fb, offs, length, converted, a);
        }
    }

    private String convertString(String str)
    {
        char[] upper = str.toCharArray();

        for (int i = 0; i < upper.length; i++)
        {
            upper[i] = Character.toUpperCase(upper[i]);
        }

        return new String( upper );
    }

    private static void createAndShowGUI()
    {
        JTextField textField = new JTextField(10);
        AbstractDocument doc = (AbstractDocument) textField.getDocument();
        doc.setDocumentFilter( new UpperCaseFilter() );

        JFrame frame = new JFrame("Upper Case Filter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout( new java.awt.GridBagLayout() );
        frame.add( textField );
        frame.setSize(220, 200);
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args) throws Exception
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