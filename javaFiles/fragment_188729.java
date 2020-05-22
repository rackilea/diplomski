@Override
protected void resizeAndRepaint()
{
    JFrame window = (JFrame)  SwingUtilities.getAncestorOfClass(JFrame.class, this);
    if(window != null && window.getState() != JFrame.ICONIFIED)
    {
        super.resizeAndRepaint();
    }
}