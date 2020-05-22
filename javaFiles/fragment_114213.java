buttons[i].addActionListener(new ActionListener() 
{
    public void actionPerformed(ActionEvent f) 
    {
        click = Integer.parseInt(f.getActionCommand());

        if (clicked[0] == -1) {
            clicked[0] = click;
        } else if (clicked[1] == -1) {
            clicked[1] = click;
        }
        ...
    }
});