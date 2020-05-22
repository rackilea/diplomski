JMenuItem newItem = new JMenuItem("New Customer");
newItem.addActionListener(this);
newItem.setActionCommand("New Customer");

public void actionPerformed(ActionEvent e) 
{
    if(e.getActionCommand().equals("New Customer"))
    {
        System.out.println("clicked new customer menu");
        MainMenu.this.dispose();
        New_Customer nn = new New_Customer() {};
    }
}