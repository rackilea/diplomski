TextAction action = new TextAction("")
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
            JTextComponent textField = getFocusedComponent();
            System.out.println( textField.getText() );
    }
};