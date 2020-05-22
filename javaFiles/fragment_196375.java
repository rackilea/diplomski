public boolean getJList(Container c)
{
    Component[] cmps = c.getComponents();
    for (Component cmp : cmps)
    {
        if (cmp instanceof JList)
        {
            modifyJList((JList)cmp);
            return true;
        }
        if (cmp instanceof Container)
        {
            if(getJList((Container) cmp)) return true;
        }
    }
    return false;
}
private void modifyJList(JList list)
{
    // Here you can modify your JList
}