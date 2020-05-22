ActionListener al = new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
         JButton button = (JButton)e.getSource();
         button.setEnabled( false );
    }
};

for(int row = 0; row < 10; row++)
{
    for(int col = 0; col < 10; col++)
    {
            button = new JButton();
            button.addActionListener( al );
            panel_1.add(button);
     }
 }