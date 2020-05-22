class ExpandListener : Java.Lang.Object, MenuItemCompat.IOnActionExpandListener
{
    Context context;

    public ExpandListener(Context pContext)
    {
        context = pContext;
    }
    public bool OnMenuItemActionCollapse(IMenuItem item)
    {
        //MyStuff with context
        return true;
    }

    public bool OnMenuItemActionExpand(IMenuItem item)
    {
        //Stuff
        return true;
    }
}