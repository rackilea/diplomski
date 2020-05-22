JButton button = new JButton( new ImageIcon("..." ));
button.setBorderPainted( false );
button.setContentFilled( false );
button.setFocusPainted( false );
button.addActionListener( new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton)e.getSource();
        Icon icon = button.getIcon();
        // do something with the Icon.
    }
});