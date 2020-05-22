ActionListener al = new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton)e.getSource();

        if (...)
            button.setVisible( false ); 
    }
};

for (...)
{
    JButton button = new JButton(...);
    button.addActionListener( al );
    panel.add( button );
}