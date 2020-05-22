import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ButtonCalculator extends JPanel
{
    private JButton[] buttons;
    private JTextField display;

    public ButtonCalculator()
    {
        Action numberAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                display.replaceSelection(e.getActionCommand());
            }
        };

        display = new JTextField();
        display.setEditable( false );
        display.setHorizontalAlignment(JTextField.RIGHT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout( new GridLayout(0, 5) );
        buttons = new JButton[10];

        for (int i = 0; i < buttons.length; i++)
        {
            String text = String.valueOf(i);
            JButton button = new JButton( text );
            button.addActionListener( numberAction );
            buttons[i] = button;
            buttonPanel.add( button );

            //  Support Key Bindings

            KeyStroke pressed = KeyStroke.getKeyStroke(text);
            InputMap inputMap = button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            inputMap.put(pressed, text);
            button.getActionMap().put(text, numberAction);
        }

        setLayout( new BorderLayout() );
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private static void createAndShowUI()
    {
        UIManager.put("Button.margin", new Insets(5, 10, 5, 10) );
        JFrame frame = new JFrame("Button Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new ButtonCalculator() );
        frame.setResizable( false );
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