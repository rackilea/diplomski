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