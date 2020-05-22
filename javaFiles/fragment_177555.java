//component.addFocusListener(this);
component.addActionListener( new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        alpha = 0;
        increment = 1;
        timer.start();
    }   
});