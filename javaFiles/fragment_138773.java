/**
 * Convenience method that takes care of special menu items (About, Preferences, Quit)
 *
 * @param name     The name of the menu item
 * @param parent   The parent {@link Menu}
 * @param listener The {@link Listener} to add to the item
 * @param id       The <code>SWT.ID_*</code> id
 */
private void addMenuItem(String name, Menu parent, Listener listener, int id)
{
    if (OSUtils.isMac())
    {
        Menu systemMenu = Display.getDefault().getSystemMenu();

        for (MenuItem systemItem : systemMenu.getItems())
        {
            if (systemItem.getID() == id)
            {
                systemItem.addListener(SWT.Selection, listener);
                return;
            }
        }
    }

    /* We get here if we're not running on a Mac, or if we're running on a Mac, but the menu item with the given id hasn't been found */
    MenuItem item = new MenuItem(parent, SWT.NONE);
    item.setText(name);
    item.addListener(SWT.Selection, listener);
}