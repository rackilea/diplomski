final JTextArea textArea = new JTextArea();
add(textArea);

JRadioButton radioButton = new JRadioButton();
add(radioButton);
radioButton.addActionListener(new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        textArea.setText("Selected");
    }
});

JRadioButton radioButton2 = new JRadioButton();
add(radioButton2);
radioButton2.addActionListener(new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        textArea.setText("Selected 2");
    }
});

radioButton.setSelected(true);