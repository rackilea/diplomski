//popupMenu.addSeparator();
popupMenu.add( new MySeparator() );
...


static class MySeparator extends JSeparator
{
    public MySeparator( )
    {
        super( JSeparator.HORIZONTAL );
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }

    /**
     * Returns the name of the L&F class that renders this component.
     *
     * @return the string "PopupMenuSeparatorUI"
     * @see JComponent#getUIClassID
     * @see UIDefaults#getUI
     */
    public String getUIClassID()
    {
        return "PopupMenuSeparatorUI";

    }
}