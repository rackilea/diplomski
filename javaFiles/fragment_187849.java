// out
boolean specialEvent;

// inside
ActionListener actionListener = new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (!specialEvent) return; // the special event is still false so no you can't do anything
        System.out.println("Hello");
    }
};