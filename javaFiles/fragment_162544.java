import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class InputFrame extends JFrame
{
    private String input;
    private JTextField text;

    public InputFrame()
    {
        super("Input Frame");
        input = "";
        text = new JTextField("");
        text.setToolTipText("Type 'exit' to stop the program.");

        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                input = text.getText();
            }
        });

        add(text);
        setResizable(false);
    }

    public String getInput()
    {
        return input;
    }

    public Boolean checkInput(String s)
    {
        if (text.getText().equals(s))
        {
            return true;
        }
        return false; //could use else to make this clearer
    }
}