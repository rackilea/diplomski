public MousePointerListener extends MouseAdapter
{
    @Override
    public void mouseEntered(MouseEvent e)
    {
        e.getComponent( setCursor(...) );
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        e.getComponent( setCursor(...) );
    }
}