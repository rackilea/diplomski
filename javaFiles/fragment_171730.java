void makeButton(String name)
{
    final JButton button =new JButton(name);
    add(button);

    button.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            button.setText("I was clicked");
        }
    });
}