MouseListener ml = new MouseAdapter()
{
    @Override
    public void mousePressed(MouseEvent e)
    {
        JPanel panel = (JPanel)e.getSource();

        // do your processing on the panel
    }
}