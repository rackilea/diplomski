public JMenu getMenuBarMenu(JMenuItem item)
{
    JMenuItem menu = null;

    while (menu == null)
    {
        JPopupMenu popup = (JPopupMenu)item.getParent();
        item = (JMenuItem)popup.getInvoker();

        if (item.getParent() instanceof JMenuBar)
            menu = item;
    }

    return (JMenu)menu;
}