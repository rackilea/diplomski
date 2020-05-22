MouseListener m = new MouseAdapter() // create our own mouse listener
{
    @Override
    public void mouseEntered(MouseEvent e) 
    {
         e.getComponent().setBackground(Color.RED);; // this method changes the colours of all the labels
    }
    @Override
    public void mouseExited(MouseEvent e)
    {
        e.getComponent().setBackground(Color.GREEN); // this method changes the colours back to normal
    }
};
for (JLabel label: labels) // iterate over all the labels
{
    label.addMouseListener(m); // give them all our mouse listener
}