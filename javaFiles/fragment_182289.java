JButton button = new JButton("Button_Leads_To_This_Window");
button.addActionListener( new ActionActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
       NewFrame();
    }
});