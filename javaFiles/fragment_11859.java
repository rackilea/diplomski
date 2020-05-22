JTextField txtInput = new JTextField("");

public class txtInputListener implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        input = txtInput.getText();   //receive input from text field
        System.out.println(input);
    }
}