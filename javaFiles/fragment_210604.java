private String showInputDialog()
{
    String inputValue = JOptionPane.showInputDialog("Please input something");

    if(inputValue == null || inputValue.isEmpty() || !inputValue.matches("[A-Za-z]*"))
    {
        inputValue = showInputDialog();
    }

    return inputValue;
}