class B extends JFrame
{
    private A myA;

    private JTextField input;

    private JButton submitButton;

    public B()
    {
        submitButton.addActionListener(new SubmitListener());
    }

    private class SubmitListener
    {
        //this method is called every time the submitButton is clicked
        public void actionPerformed(ActionEvent ae)
        {
            myA.sendInput(inputField.getText());
            //A will need a method sendInput(String)
        }
    }
}