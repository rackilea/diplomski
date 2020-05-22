public class WindowFollowListener extends ComponentAdapter
{
    private boolean enabled = true;
    private Window followingWindow;
    private Window parentWindow;
    private Point ll;

    public WindowFollowListener ( Window followingWindow, Window parentWindow )
    {
        super ();

        this.followingWindow = followingWindow;
        this.parentWindow = parentWindow;
        this.ll = parentWindow.getLocation ();

        parentWindow.addComponentListener ( this );
    }

    public boolean isEnabled ()
    {
        return enabled;
    }

    public void setEnabled ( boolean enabled )
    {
        this.enabled = enabled;
    }

    public Window getFollowingWindow ()
    {
        return followingWindow;
    }

    public void setFollowingWindow ( Window followingWindow )
    {
        this.followingWindow = followingWindow;
    }

    public Window getParentWindow ()
    {
        return parentWindow;
    }

    public void setParentWindow ( Window parentWindow )
    {
        this.parentWindow = parentWindow;
    }

    public void componentResized ( ComponentEvent e )
    {
        this.ll = parentWindow.getLocation ();
    }

    public void componentMoved ( ComponentEvent e )
    {
        if ( enabled && followingWindow != null && parentWindow != null )
        {
            Point nl = parentWindow.getLocation ();
            Point fwl = followingWindow.getLocation ();
            followingWindow.setLocation ( fwl.x + nl.x - ll.x, fwl.y + nl.y - ll.y );
            this.ll = nl;
        }
    }
}