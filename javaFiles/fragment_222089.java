import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

public class NumpadPanel extends JPanel
{
    public NumpadPanel()
    {
        setLayout( new BorderLayout() );

        JTextField textField1 = new JTextField(4);
        JTextField textField2 = new JTextField(2);
        JTextField textField3 = new JTextField(2);

        JPanel panel = new JPanel();
        panel.add( textField1 );
        panel.add( textField2 );
        panel.add( textField3 );
        add(panel, BorderLayout.PAGE_START);

        Action numberAction = new TextAction("")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JTextComponent textComponent = getFocusedComponent();

                if (textComponent != null)
                    textComponent.replaceSelection(e.getActionCommand());
            }
        };

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout( new GridLayout(0, 5) );
        add(buttonPanel, BorderLayout.CENTER);

        for (int i = 0; i < 10; i++)
        {
            String text = String.valueOf(i);
            JButton button = new JButton( text );
            button.addActionListener( numberAction );
            button.setMargin( new Insets(20, 20, 20, 20) );
            button.setFocusable( false );
            buttonPanel.add( button );
        }
    }

    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("Numpad Panel");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( new NumpadPanel() );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
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