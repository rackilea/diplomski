import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class TextActionTest extends JFrame
{
    JTextField textField = new JTextField("Select Me");
    JTabbedPane tabbedPane;

    public TextActionTest()
    {
        add(textField, BorderLayout.NORTH);
        add(new JCheckBox("Click Me!"));
        add(new JButton(new CutAction()), BorderLayout.SOUTH);
    }

    public static void main(String[] args)
    {
        TextActionTest frame = new TextActionTest();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
     }

    class CutAction extends TextAction
    {
        public CutAction()
        {
            super("Click to Cut Text");
        }

        public void actionPerformed(ActionEvent e)
        {
            JTextComponent component = getFocusedComponent();
//          JTextComponent component = getTextComponent(e);
            component.cut();
        }
    }
}