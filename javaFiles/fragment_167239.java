import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class NoTextSelectionCaret extends DefaultCaret
{
    public NoTextSelectionCaret(JTextComponent textComponent)
    {
        setBlinkRate( textComponent.getCaret().getBlinkRate() );
        textComponent.setHighlighter( null );
    }

    @Override
    public int getMark()
    {
        return getDot();
    }

    private static void createAndShowUI()
    {
        JTextField textField1 = new JTextField("No Text Selection Allowed");
        textField1.setCaret( new NoTextSelectionCaret( textField1 ) );
        textField1.setEditable(false);

        JTextField textField2 = new JTextField("Text Selection Allowed");

        JFrame frame = new JFrame("No Text Selection Caret");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(textField1, BorderLayout.NORTH);
        frame.add(textField2, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}