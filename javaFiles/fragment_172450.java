@Override
public void hierarchyChanged(HierarchyEvent e)
{
    JComponent component = (JComponent)e.getSource();

    if ((HierarchyEvent.SHOWING_CHANGED & e.getChangeFlags()) != 0
    &&  component.isShowing())
    {
        // start the Timer
    }
}