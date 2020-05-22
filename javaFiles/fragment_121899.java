import javax.swing.*;
import java.awt.event.ActionEvent;

class KeyBindingExample extends JFrame
{
    private JButton button;
    private Action changeTextAction;

    public KeyBindingExample()
    {
        button = new JButton("Not Pressed!");
        changeTextAction = new ChangeTextAction(button, "Pressed!");

        button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "pressed");
        button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "pressed");

        button.getActionMap().put("pressed", changeTextAction);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(button);
        pack();
        setVisible(true);
    }

    public class ChangeTextAction extends AbstractAction
    {
        private JButton button;
        private String text;

        public ChangeTextAction(JButton button, String text)
        {
            this.button = button;
            this.text = text;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            button.setText(text);
        }
    }

    public static void main(String[] args)
    {
        new KeyBindingExample();
    }
}