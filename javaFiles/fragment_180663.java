d.addWindowListener(new WindowAdapter()
{
    public void windowActivated(WindowEvent e)
    {
        d.setBackground(new Color(0, 0, 0, 0));
    }

    public void windowDeactivated(WindowEvent e)
    {
        d.setBackground(Color.white);
    }
});