List<String> list = new ArrayList<String>();

// ...

button.addActionListener(new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String text = textField.getText();
        list.add(text);
    }
});